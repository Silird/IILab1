package Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.neusoft.de.nts.OneCoreTest.communication.messageModel.BaseCommand;
import com.neusoft.de.nts.OneCoreTest.communication.messageModel.BaseRequest;
import com.neusoft.de.nts.OneCoreTest.communication.messageModel.BaseResponse;
import com.neusoft.de.nts.OneCoreTest.interfaces.ITransport;
import com.neusoft.de.nts.OneCoreTest.utils.EProjectInterfaceType;
import com.neusoft.de.nts.OneCoreTest.utils.Logger;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public abstract class AbstractDelegator {

    protected final static Map<BaseCommand, Class<? extends BaseCommand>> mapCommandClass = new HashMap<>();
    private final static Logger logger = Logger.getLogger(AbstractDelegator.class);
    protected final Map<Class<? extends BaseCommand>, Consumer<BaseCommand>> mapClassMethods = new HashMap<>();

    protected final ITransport<BaseCommand, String> client;
    protected final Executor executor;
    protected final Gson gson;
    private final String className = this.getClass().getSimpleName();

    private Subscription processCommand;

    public AbstractDelegator(Gson gson, ITransport<BaseCommand, String> client, Executor executor) {
        this.gson = gson;
        this.client = client;
        this.executor = executor;
    }

    /**
     * @deprecated provided, because currently available delegator implementations dont pass gson parameter.
     * Need to update them but this requires update of generator.
     */
    @Deprecated
    public AbstractDelegator(ITransport<BaseCommand, String> client, Executor executor) {
        this(EProjectInterfaceType.OCTA.getGson(), client, executor);
    }


    public synchronized void startProcess() {
        stopProcess();
        processCommand = client.getObservable().observeOn(Schedulers.from(executor)).subscribe(this::processCommands);
    }

    public synchronized void stopProcess() {
        if (processCommand != null) {
            processCommand.unsubscribe();
        }
    }

    private final void processCommands(String json) {
        BaseCommand cmd = gson.fromJson(json, BaseCommand.class);
        Class<? extends BaseCommand> clz = mapCommandClass.get(cmd);

        if (clz != null) {
            try {
                BaseCommand concrete = gson.fromJson(json, clz);
                mapClassMethods.get(clz).accept(concrete);
            } catch (JsonSyntaxException e) {
                logger.error(e, "%s: Error parsing ", className, json);
            }
        } else {
            logger.warn("%s: Cannot find process method for message %s", className, json);
        }
    }

    protected void sendResponse(BaseRequest req, BaseResponse res) {
        res.setRoutingKey(req.getSenderRoutingKey());
        logger.info("%s.sendResponse: %s", className, res);
        client.send(res);
    }

}

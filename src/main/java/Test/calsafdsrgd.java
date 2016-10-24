package Test;

/**
 * Project: Neusoft Automotives Navigation
 * Company: Neusoft Automotives
 * (c) Copyright 2013-2016
 * All rights reserved.
 *
 * THIS FILE HAS BEEN GENERATED. DO NOT EDIT IT MANUALLY!
 *
 * Generator    : ApiFiddler
 * Version      : 1.18.0-dev
 * Processor    : test-FrameWork-actors
 */

 bla bla


@SuppressWarnings("unused")
@Generated(value = "Apifidl.TestFrameWorkActorsOutputProcessor")
public class MapViewerControlActorDelegator extends AbstractDelegator
{
    private final static Logger logger = Logger.getLogger(MapViewerControlActorDelegator.class);
    private final IMapViewerControlProcessor requests;

    static
    {

        mapCommandClass.put(new ReqGetCurrentZoomLevel(), ReqGetCurrentZoomLevel.class);

        mapCommandClass.put(new ReqGetMaxZoomLevel(), ReqGetMaxZoomLevel.class);

        mapCommandClass.put(new ReqGetMinZoomLevel(), ReqGetMinZoomLevel.class);

        mapCommandClass.put(new ReqSetZoomLevel(), ReqSetZoomLevel.class);

        mapCommandClass.put(new ReqZoomIn(), ReqZoomIn.class);

        mapCommandClass.put(new ReqZoomOut(), ReqZoomOut.class);

        mapCommandClass.put(new ReqZoomToMinLevel(), ReqZoomToMinLevel.class);

        mapCommandClass.put(new ReqZoomToMaxLevel(), ReqZoomToMaxLevel.class);

        mapCommandClass.put(new ReqScrollMap(), ReqScrollMap.class);

        mapCommandClass.put(new ReqMoveMapTo(), ReqMoveMapTo.class);

        mapCommandClass.put(new ReqGetCurrentCameraPosition(), ReqGetCurrentCameraPosition.class);

        mapCommandClass.put(new ReqSetFollowCarMode(), ReqSetFollowCarMode.class);

        mapCommandClass.put(new ReqSetMapOrientation(), ReqSetMapOrientation.class);

    }


    public MapViewerControlActorDelegator(com.google.gson.Gson gson, ITransport<BaseCommand, String> client, Executor executor, IMapViewerControlProcessor requests)
    {
        super(gson, client, executor);
        this.requests = requests;
        mapClassMethods.put(ReqGetCurrentZoomLevel.class, this::processReqGetCurrentZoomLevel);

        mapClassMethods.put(ReqGetMaxZoomLevel.class, this::processReqGetMaxZoomLevel);

        mapClassMethods.put(ReqGetMinZoomLevel.class, this::processReqGetMinZoomLevel);

        mapClassMethods.put(ReqSetZoomLevel.class, this::processReqSetZoomLevel);

        mapClassMethods.put(ReqZoomIn.class, this::processReqZoomIn);

        mapClassMethods.put(ReqZoomOut.class, this::processReqZoomOut);

        mapClassMethods.put(ReqZoomToMinLevel.class, this::processReqZoomToMinLevel);

        mapClassMethods.put(ReqZoomToMaxLevel.class, this::processReqZoomToMaxLevel);

        mapClassMethods.put(ReqScrollMap.class, this::processReqScrollMap);

        mapClassMethods.put(ReqMoveMapTo.class, this::processReqMoveMapTo);

        mapClassMethods.put(ReqGetCurrentCameraPosition.class, this::processReqGetCurrentCameraPosition);

        mapClassMethods.put(ReqSetFollowCarMode.class, this::processReqSetFollowCarMode);

        mapClassMethods.put(ReqSetMapOrientation.class, this::processReqSetMapOrientation);

    }


    private void  processReqGetCurrentZoomLevel(BaseCommand baseCommand)
    {
        try {
            ReqGetCurrentZoomLevel cmd = (ReqGetCurrentZoomLevel) baseCommand;
            requests.processReqGetCurrentZoomLevel(cmd).thenAccept(rs -> sendResponse(cmd, rs)).exceptionally(ex -> {
                logger.error(ex, "In lambda processReqGetCurrentZoomLevel");
                return null;
            });
        } catch (ClassCastException e) {
            logger.error(e, "Cast failed");
        }
    }

    private void  processReqGetMaxZoomLevel(BaseCommand baseCommand)
    {
        try {
            ReqGetMaxZoomLevel cmd = (ReqGetMaxZoomLevel) baseCommand;
            requests.processReqGetMaxZoomLevel(cmd).thenAccept(rs -> sendResponse(cmd, rs)).exceptionally(ex -> {
                logger.error(ex, "In lambda processReqGetMaxZoomLevel");
                return null;
            });
        } catch (ClassCastException e) {
            logger.error(e, "Cast failed");
        }
    }
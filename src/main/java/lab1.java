import java.util.Stack;

public class lab1 {
    public static void main(String[] args) {
        //State state = new State(7, 4, 2, 3, 5, 8, 6, State.EMPTY, 1);
        //State target = new State(7, 4, 2, State.EMPTY, 5, 8, 6, 1, 3);


        //State target = new State(1, 2, 3, 4, State.EMPTY, 5, 6, 7, 8);
        //State state = new State(5, 8, 3, 4, State.EMPTY, 2, 7, 6, 1);
        //State target = new State(1, 2, 3, 4, 5, 6, 7, 8, State.EMPTY);

        State state = new State(5, 8, 3, 4, State.EMPTY, 2, 7, 6, 1);
        // -- State target = new State(1, 2, 3, 4, 5, 6, 7, 8, State.EMPTY);
        State target = new State(State.EMPTY, 1, 2, 3, 4, 5, 6, 7, 8);

        new SearchLimitedDeep(target, false, 25).Start(state);
        //new SearchWidth(target, false).Start(state);
    }
}

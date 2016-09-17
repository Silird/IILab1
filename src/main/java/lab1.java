import java.io.IOException;

public class lab1 {
    public static void main(String[] args) {
        Cell cell = new Cell(1, 2, 3, 4, 5, 6, 7, 8, Cell.EMPTY);
        Cell target = new Cell(1, 2, 3, Cell.EMPTY, 4, 5, 7, 8, 6);
        new Work(target, true).Start(cell);
    }
}

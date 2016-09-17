public class lab1 {
    public static void main(String[] args) {
        Cell cell = new Cell(7, 4, 2, 3, 5, 8, 6, Cell.EMPTY, 1);
        Cell target = new Cell(1, 2, 3, 4, Cell.EMPTY, 5, 6, 7, 8);
        //Cell target = new Cell(7, 4, 2, Cell.EMPTY, 5, 8, 6, 1, 3);
        //new WorkLimitedDeep(target, false, 1000000).Start(cell);
        new WorkWidth(target, false).Start(cell);
    }
}

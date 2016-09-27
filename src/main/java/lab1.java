public class lab1 {
    public static void main(String[] args) {
        Cell cell = new Cell(7, 4, 2, 3, 5, 8, 6, Cell.EMPTY, 1);
        //Cell target = new Cell(1, 2, 3, 4, Cell.EMPTY, 5, 6, 7, 8);
        //Cell cell = new Cell(5, 8, 3, 4, Cell.EMPTY, 2, 7, 6, 1);
        //Cell target = new Cell(1, 2, 3, 4, 5, 6, 7, 8, Cell.EMPTY);
        Cell target = new Cell(7, 4, 2, Cell.EMPTY, 5, 8, 6, 1, 3);
        new SearchLimitedDeep(target, false, 20).Start(cell);
        //new SearchWidth(target, false).Start(cell);

        /*
        Cell tmp1 = new Cell(1, 2, 3, 4, Cell.EMPTY, 5, 6, 7, 8);
        tmp1.Print();
        System.out.println();
        tmp1.Move(Cell.RIGHT).Print();
        */

        /*
        cell.Print();
        System.out.println();
        target.Print();
        */
    }
}

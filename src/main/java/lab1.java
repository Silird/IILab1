public class lab1 {
    public static void main(String[] args) {
        Cell cell = new Cell(1, 2, 3, 4, 5, 6, 7, 8, Cell.EMPTY);
        cell.Print();

        System.out.println();


        cell = cell.Move(Cell.LEFT);
        if (cell != null) {
            cell.Print();
        }
        else {
            System.out.println("Нет такой ячейки");
        }
    }
}

import java.io.IOException;
import java.util.*;

public class Work {
    private boolean step;
    private int iteration;
    private List<Cell> used = new ArrayList<Cell>();
    private Queue<Cell> queue = new PriorityQueue<Cell>();
    private Cell target;

    public Work(Cell target, boolean step) {
        this.target = target;
        this.step = step;
    }

    public Work(Cell target) {
        this(target, false);
    }

    public void Start(Cell start) {
        queue.add(start);
        iteration = 0;
        Open();
    }

    private void Open() {
        Cell currentCell = queue.poll();
        used.add(currentCell);
        iteration++;
        if (step) {
            System.out.println("-------------------------Итерация № " + iteration + "-------------------------------");
            System.out.println("Раскрывается вершина:\n");
            currentCell.Print();

            System.out.println("\nВновь открытые:\n");
        }
        Add(currentCell.Move(Cell.UP));
        Add(currentCell.Move(Cell.RIGHT));
        Add(currentCell.Move(Cell.DOWN));
        Add(currentCell.Move(Cell.LEFT));

        PrintQueue();

        if (step) {
            System.out.println("\nСледующая для открытия:\n");
            queue.peek().Print();

            try {
                System.out.println("\nНажмите Enter для продолжения");
                System.in.read();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Open();
    }

    private void Add(Cell cell) {
        if (cell != null) {
            if (cell.equals(target)) {
                End(cell);
            }
            if (!used.contains(cell) && !queue.contains(cell)) {
                queue.add(cell);
                if (step) System.out.println("Добавляется в очередь:");
            }
            else {
                if (step) System.out.println("Не добавляется в очередь:");
            }
            if (step) cell.Print();
        }
    }

    private void PrintQueue() {
        if (step) {
            System.out.println("Вершины, ожидающие открытия:\n");
            for (Cell cell : queue) {
                cell.Print();
                System.out.println();
            }
        }
    }

    private void End(Cell cell) {
        Stack<Cell> path = new Stack<Cell>();
        System.out.println("Найдено решение:\n");
        cell.Print();
        path.add(cell);
        Cell tmp = cell.getParent();
        while (tmp != null) {
            path.add(tmp);
            tmp = tmp.getParent();
        }
        System.out.println("\nНайдено решение в " + cell.getDeep() + " шаг/а/ов");
        System.out.println("Путь:\n");

        while (!path.isEmpty()) {
            tmp = path.pop();
            tmp.Print();

            System.out.println();
        }

        try {
            System.out.println("Нажмите Enter для выхода");
            System.in.read();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }
}

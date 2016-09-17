public class Cell {
    public final static int UP = 0;
    public final static int RIGHT = 1;
    public final static int DOWN = 2;
    public final static int LEFT = 3;

    private final static int SIZE = 3;

    public final static int EMPTY = 0;

    private int[][] inCell = new int[SIZE][SIZE];

    public Cell(int c00, int c01, int c02,
                int c10, int c11, int c12,
                int c20, int c21, int c22) {
        inCell[0][0] = c00;
        inCell[0][1] = c01;
        inCell[0][2] = c02;
        inCell[1][0] = c10;
        inCell[1][1] = c11;
        inCell[1][2] = c12;
        inCell[2][0] = c20;
        inCell[2][1] = c21;
        inCell[2][2] = c22;
    }

    public Cell(Cell cell) {
        inCell = cell.getInCell();
    }

    public Cell Move(int direction) {
        Cell result = new Cell(this);
        Position empty = this.getEmpty();
        switch (direction) {
            case (UP) : {
                if (empty.getY() == 0) {
                    return null;
                }
                result.getInCell()[empty.getY()][empty.getX()] = result.getInCell()[empty.getY() - 1][empty.getX()];
                result.getInCell()[empty.getY() - 1][empty.getX()] = EMPTY;
                break;
            }
            case (RIGHT) : {
                if (empty.getX() == (SIZE - 1)) {
                    return null;
                }
                result.getInCell()[empty.getY()][empty.getX()] = result.getInCell()[empty.getY()][empty.getX() + 1];
                result.getInCell()[empty.getY()][empty.getX() + 1] = EMPTY;
                break;
            }
            case (DOWN) : {
                if (empty.getY() == (SIZE - 1)) {
                    return null;
                }
                result.getInCell()[empty.getY()][empty.getX()] = result.getInCell()[empty.getY() + 1][empty.getX()];
                result.getInCell()[empty.getY() + 1][empty.getX()] = EMPTY;
                break;
            }
            case (LEFT) : {
                if (empty.getX() == 0) {
                    return null;
                }
                result.getInCell()[empty.getY()][empty.getX()] = result.getInCell()[empty.getY()][empty.getX() - 1];
                result.getInCell()[empty.getY()][empty.getX() - 1] = EMPTY;
                break;
            }
        }
        return result;
    }

    public void Print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(inCell[i][j] + "   ");
            }
            System.out.print("\n");
        }
    }

    public Position getEmpty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (inCell[i][j] == EMPTY) {
                    return new Position(j, i);
                }
            }
        }

        return null;
    }

    public int[][] getInCell() {
        return inCell;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }

        int[][] eqInCell = ((Cell) object).getInCell();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (inCell[i][j] != eqInCell[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

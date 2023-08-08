public class Model {
    private int size;
    private int numMines;
    private Square[][] grid;

    private class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Square {
        int numAdjMines;
        boolean mine;
        boolean checked;
        Position position;
        Square(Position position) {
            numAdjMines = 0;
            mine = false;
            checked = false;
            this.position = position;
        }
    }
    Model(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        grid = new Square[size][size];
    }

    private void generateGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Square(new Position(i, j));
            }
        }
        for (int i = 0; i < numMines; i++) {
            Position randomPosition = generateRandomPosition();
            while (getSquare(randomPosition).mine) {
                randomPosition = generateRandomPosition();
            }
            getSquare(randomPosition).mine = true;
            // TODO increase numAdjMines for adjacent square
        }
    }

    private Position generateRandomPosition() {
        return new Position((int) Math.floor(Math.random() * size), (int) Math.floor(Math.random() * size));
    }

    private Square getSquare(Position position) {
        return grid[position.x][position.y];
    }

    public Square getSquare(int x, int y) {
        return grid[x][y];
    }
}

package co.tide.escape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesar on 6/11/17.
 */
public class Maze {

    public static final char WALL = 'O';
    public static final char FREE = ' ';
    public static final char PATH = '•';

    private final char[][] matrix;
    private MazePosition exit;

    public Maze(final char[][] matrix) {
        if(matrix.length < 4 || matrix[0].length < 4){
            throw new IllegalArgumentException("matrix must be at least 4x4");
        }

        this.matrix = matrix;

        for (int i = 0; i < matrix.length; i++) {

            int firstCol = 0;
            if (matrix[i][firstCol] == FREE) {
                exit = new MazePosition(i, 0);
                break;
            }

            int lastCol = matrix[i].length - 1;
            if (matrix[i][lastCol] == FREE) {
                exit = new MazePosition(i, lastCol);
                break;
            }

        }

        for (int j = 1; j < matrix[0].length - 1; j++) {

            int firstRow = 0;
            if (matrix[firstRow][j] == FREE) {
                exit = new MazePosition(firstRow, j);
            }

            int lastRow = 0;
            if (matrix[lastRow][j] == FREE) {
                exit = new MazePosition(lastRow, j);
            }

        }

    }

    public MazePosition getExit() {
        return exit;
    }

    public List<MazePosition> getNeighbourPaths(MazePosition position) {
        List<MazePosition> paths = new ArrayList<>();

        char p = getPosition(position.getX() - 1, position.getY());
        if (p == FREE) {
            paths.add(new MazePosition(position.getX() - 1, position.getY()));
        }

        p = getPosition(position.getX() + 1, position.getY());
        if (p == FREE) {
            paths.add(new MazePosition(position.getX() + 1, position.getY()));
        }

        p = getPosition(position.getX(), position.getY() - 1);
        if (p == FREE) {
            paths.add(new MazePosition(position.getX(), position.getY() - 1));
        }

        p = getPosition(position.getX(), position.getY() + 1);
        if (p == FREE) {
            paths.add(new MazePosition(position.getX(), position.getY() + 1));
        }

        return paths;
    }

    private char getPosition(int x, int y) {
        try {
            return matrix[x][y];
        } catch (IndexOutOfBoundsException ex) {
            return WALL;
        }
    }
}

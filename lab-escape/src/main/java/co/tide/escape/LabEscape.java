package co.tide.escape;

import co.tide.escape.exceptions.NoEscapeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Please implement your solution here
 */
public class LabEscape {

    private static List<MazePosition> visited;
    private static List<MazePosition> pathToExit;

    /**
     * @param labyrinth A labyrinth drawn on a matrix of characters. It's at least 4x4, can be a rectangle or a square.
     *                  Walkable areas are represented with a space character, walls are represented with a big O character.
     *                  The escape point is always on the border (see README)
     * @param startX    Starting row number for the escape. 0 based.
     * @param startY    Starting column number for the escape. 0 based.
     * @return A char matrix with the same labyrinth and a path drawn from the starting point to the escape
     * @throws NoEscapeException when no path exists to the outside, from the selected starting point
     */
    public static char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException {

        Maze maze = new Maze(labyrinth);
        MazePosition start = new MazePosition(startX, startY);

        if(labyrinth[startX][startY] == Maze.WALL){
            throw new NoEscapeException();
        }

        visited = new ArrayList<>();
        pathToExit = new ArrayList<>();

        if (!searchForPathToExit(maze, start)) {
            throw new NoEscapeException();
        }

        for (MazePosition p : pathToExit) {
            labyrinth[p.getX()][p.getY()] = Maze.PATH;
        }

        return labyrinth;
    }

    private static boolean searchForPathToExit(Maze maze, MazePosition position) {

        visited.add(position);
        pathToExit.add(position);

        if (position.equals(maze.getExit())) {
            return true;
        }

        boolean hasFoundExit = false;
        List<MazePosition> possiblePaths = maze.getNeighbourPaths(position);

        for (MazePosition p : possiblePaths) {

            if (!visited.contains(p)) {
                hasFoundExit = searchForPathToExit(maze, p);
            }

            if (hasFoundExit) {
                return true;
            }

        }

        pathToExit.remove(position);
        return false;
    }

}

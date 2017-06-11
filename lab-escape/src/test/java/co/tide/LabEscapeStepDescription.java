package co.tide;

import co.tide.common.maze.MazeUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static co.tide.common.maze.asserts.MazeAssert.assertMazesAreEqual;

/**
 * Created by cesar on 6/11/17.
 */
public class LabEscapeStepDescription {

    private static final char PATH = ' ';
    private char[][] maze;
    private int startX;
    private int startY;
    private char[][] actual;

    @Given("^a maze as follows$")
    public void a_maze_as_follows(List<List<String>> matrix) throws Throwable {
        this.maze = MazeUtils.toCharMatrix(matrix);
    }

    @Given("^the starting point X (\\d+) and Y (\\d+)$")
    public void the_starting_point_X_and_Y(int startX, int startY) throws Throwable {
        this.startX = startX;
        this.startY = startY;
    }

    @When("^we search for an exit path$")
    public void we_search_for_an_exit_path() throws Throwable {

        this.actual = LabEscape.drawPathForEscape(maze, startX, startY);

    }

    @Then("^the path should be drawn as follows$")
    public void the_path_should_be_drawn_as_follows(List<List<String>> matrix) throws Throwable {

        char[][] expected = MazeUtils.toCharMatrix(matrix);

        assertMazesAreEqual(expected, actual);

    }

}

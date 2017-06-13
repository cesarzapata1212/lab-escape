Feature: Lab Escape

  The Lab Escape accepts a "maze" structure as input, along with starting point,
  and returns the solution to said maze.

  Scenario: Starting point is the exit
    Given a maze as follows
      | O | O | O | O |
      | O |   |   |   |
      | O |   |   | O |
      | O | O | O | O |
    And the starting point X 1 and Y 3
    When we search for an exit path
    Then the path should be drawn as follows
      | O | O | O | O |
      | O |   |   | • |
      | O |   |   | O |
      | O | O | O | O |


  Scenario: Starting point is next to the exit
    Given a maze as follows
      | O | O | O | O |
      | O |   |   |   |
      | O |   |   | O |
      | O | O | O | O |
    And the starting point X 1 and Y 2
    When we search for an exit path
    Then the path should be drawn as follows
      | O | O | O | O |
      | O |   | • | • |
      | O |   |   | O |
      | O | O | O | O |

  Scenario: Find exit in a straight line
    Given a maze as follows
      | O | O | O | O |
      | O |   |   |   |
      | O | O | O | O |
      | O | O | O | O |
    And the starting point X 1 and Y 1
    When we search for an exit path
    Then the path should be drawn as follows
      | O | O | O | O |
      | O | • | • | • |
      | O | O | O | O |
      | O | O | O | O |


  Scenario: Find exit in a complex path
    Given a maze as follows
      | O | O | O | O | O | O | O | O | O | O |
      | O |   |   |   |   | O |   |   |   | O |
      | O |   | O | O |   | O |   | O |   | O |
      | O |   |   | O |   | O |   | O |   | O |
      | O |   | O | O |   |   |   | O |   |   |
      | O |   | O | O | O | O | O | O | O | O |
      | O |   |   |   |   |   |   |   |   | O |
      | O | O | O | O | O | O | O | O | O | O |
    And the starting point X 3 and Y 1
    When we search for an exit path
    Then the path should be drawn as follows
      | O | O | O | O | O | O | O | O | O | O |
      | O | • | • | • | • | O | • | • | • | O |
      | O | • | O | O | • | O | • | O | • | O |
      | O | • |   | O | • | O | • | O | • | O |
      | O |   | O | O | • | • | • | O | • | • |
      | O |   | O | O | O | O | O | O | O | O |
      | O |   |   |   |   |   |   |   |   | O |
      | O | O | O | O | O | O | O | O | O | O |


  Scenario: two different paths does not get in loop
    Given a maze as follows
      | O | O | O | O | O |
      | O |   |   |   |   |
      | O |   | O |   | O |
      | O |   |   |   | O |
      | O | O | O | O | O |
    And the starting point X 3 and Y 1
    When we search for an exit path
    Then the path should be drawn as follows
      | O | O | O | O | O |
      | O | • | • | • | • |
      | O | • | O |   | O |
      | O | • |   |   | O |
      | O | O | O | O | O |


  Scenario: No path to exit
    Given a maze as follows
      | O | O | O |   |
      | O |   |   | O |
      | O |   |   | O |
      | O | O | O | O |
    And the starting point X 1 and Y 1
    When we search for an exit path
    Then we should receive an error


  Scenario: matrix width is too small
    Given a maze as follows
      | O | O | O |
      | O |   | O |
      | O |   |   |
      | O | O | O |
    And the starting point X 1 and Y 1
    When we search for an exit path
    Then we should receive an error


  Scenario: starting point is same as wall
    Given a maze as follows
      | O | O | O | O | O |
      | O |   |   |   | O |
      | O |   | O |   |   |
      | O |   |   |   | O |
      | O | O | O | O | O |
    And the starting point X 2 and Y 2
    When we search for an exit path
    Then we should receive an error

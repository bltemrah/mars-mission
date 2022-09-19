Feature: Navigator commands for the direction and movement of the rover
  As a rover navigator, I should be able to send my commands to the rover
  to control its direction and movement for the capture of video of the planet Mars

  Background: The rover is landed on mars
    Given the rover upper-right movement coordination x 5, y 5

  # First, the x and y coordination need to be defined. All below scenarios are based on the initial defined coordination
  # As known, I added the negative test scenarios because the potantial defect/bug can be mostly found with negative test scenarios

  @positive
  Scenario Outline: Navigator should be able to set the coordination between zero and initial positive coordination
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    Then the rover should be able to move in the positive x and y coordination zone

    Examples:
      | axisX1 | axisY1 | direction1 |
      | 0      | 0      | 1          |
      | 5      | 5      | 3          |
      | 1      | 2      | 2          |
      | 3      | 4      | 4          |
      | 2      | 3      | 3          |

  # the below scenario for out of boundary
  @negative
  Scenario Outline: Navigator should not be able to set less than zero as the initial coordination for the rover
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    Then the rover should not be able to move the negative x and y coordination zone

    Examples:
      | axisX1 | axisY1 | direction1 |
      | -1     | 3      | 1          |
      | 3      | -1     | 3          |

  # The below scenarios are positvive and for particularly multi commands
  @positive
  Scenario Outline: Navigator should be able to send multiple navigation commands sequentially
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    And  the navigator orders a series of navigation command as <commands>
    Then the rover is settled at coordinates x = <axisX2> and y = <axisY2>
    And  the rover is facing towards <direction2>

    Examples:
      | axisX1 | axisY1 | direction1 | commands   | axisX2 | axisY2 | direction2 |
      | 1      | 2      | 1          | LMLMLMLMM  | 1      | 3      | north      |
      | 3      | 3      | 2          | MMRMMRMRRM | 5      | 1      | east       |
      | 3      | 3      | 3          | MMRMMRMRRM | 1      | 1      | south      |
      | 3      | 3      | 4          | MMRMMRMRRM | 1      | 5      | west       |

  # The below scenarios are negative and for particularly multi commands
  @negative
  Scenario Outline: The rover should not be able to move out of boundary coordination
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    And  the navigator orders a series of navigation command as <commands>
    Then the rover is out of coordination boundary

    Examples:
      | axisX1 | axisY1 | direction1 | commands     |
      | 3      | 3      | 2          | MMMMRMMRMRRM |
      | 0      | 0      | 1          | LMMMM        |
      | 0      | 0      | 4          | RMMRMRRM     |
      | 5      | 5      | 3          | MMMMMMMMM    |

  # the below four scenarios for single movement and direction commands
  @positive @singleMovement
  Scenario Outline: The navigator should be able to command the rover to turn left
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    And  the navigator orders a series of navigation command as <commands>
    Then the rover is settled at coordinates x = <axisX2> and y = <axisY2>
    And  the rover is facing towards <direction2>

    Examples:
      | axisX1 | axisY1 | direction1 | commands | axisX2 | axisY2 | direction2 |
      | 0      | 0      | 1          | L      | 0      | 0      | west      |

  @positive @singleMovement
  Scenario Outline: The navigator should be able to command the rover to turn right
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    And  the navigator orders a series of navigation command as <commands>
    Then the rover is settled at coordinates x = <axisX2> and y = <axisY2>
    And  the rover is facing towards <direction2>

    Examples:
      | axisX1 | axisY1 | direction1 | commands | axisX2 | axisY2 | direction2 |
      | 0      | 0      | 1          | R      | 0      | 0      | east      |

  @positive @singleMovement
  Scenario Outline: The navigator should be able to command the rover to move forward
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    And  the navigator orders a series of navigation command as <commands>
    Then the rover is settled at coordinates x = <axisX2> and y = <axisY2>
    And  the rover is facing towards <direction2>

    Examples:
      | axisX1 | axisY1 | direction1 | commands | axisX2 | axisY2 | direction2 |
      | 0      | 0      | 1          | M      | 0      | 1      | north      |

  @positive @singleMovement
  Scenario Outline: The navigator should be able to command the rover to move back
    When the navigator orders the navigation coordinates as x = <axisX1> and y = <axisY1> facing <direction1>
    And  the navigator orders a series of navigation command as <commands>
    Then the rover is settled at coordinates x = <axisX2> and y = <axisY2>
    And  the rover is facing towards <direction2>

    Examples:
      | axisX1 | axisY1 | direction1 | commands | axisX2 | axisY2 | direction2 |
      | 0      | 2      | 1          | LLM      | 0      | 1      | south      |
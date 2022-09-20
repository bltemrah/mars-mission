# QA TASK
### ROBOTIC ROVER NAVIGATION ON MARS PROJECT

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.

In this test project, we can test the ability of the robotic rover to navigate from one location to another. We will be testing the following functionalities: 

- movement in a straight line
- turning left and right

We expect that the robotic rover will be able to successfully navigate over the planet Mars.

### Key Features

- Framework: Cucumber BDD framework with Maven
- Software language: Java 11
- Project build: Gradle
- Library: JUnit & TestNG

### Test scenarios

  This project covers the below test scenarios:  <br />

- Navigator should be able to set the coordination between zero and initial positive coordination
- Navigator should not be able to set less than zero as the rover initial coordination
- Navigator should be able to send multiple navigation commands sequentially
- The rover should not be able to move out of boundary coordination
- The navigator should be able to command the rover to turn left
- The navigator should be able to command the rover to turn right
- The navigator should be able to command the rover to move forward
- The navigator should be able to command the rover to move back

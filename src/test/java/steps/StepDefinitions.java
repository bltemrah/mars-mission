package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import navigation.Controller;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class StepDefinitions {

    Controller controller = new Controller();
    SoftAssert softAssert = new SoftAssert();

    @Given("the rover upper-right movement coordination x {int}, y {int}")
    public void theRoverUpperRightMovementCoordinationXY(int maxX, int maxY) {

        controller.coordinationSize(maxX, maxY);
    }

    @When("the navigator orders the navigation coordinates as x = {int} and y = {int} facing {int}")
    public void theNavigatorSendsTheNavigationCoordinatesAsXAndY(int coordinateX, int coordinateY, int direction) {

        controller.setPosition(coordinateX, coordinateY, direction);
        System.out.println("Move: The rover has moved to a given location "
                + "(" + Controller.getPosition() + ")");
    }

    @When("^the navigator orders a series of navigation command as (.*)$")
    public void theOperatorSendsASeriesOfNavigationCommandAs(String commands) {
        controller.process(commands);
    }

    @Then("the rover is settled at coordinates x = {int} and y = {int}")
    public void theRoverIsSettledAtCoordinatesXAndY(int coordinateX, int coordinateY) {
        var actualX = controller.getAxisX();
        var actualY = controller.getAxisY();

        softAssert.assertEquals(actualX, coordinateX,
                "Coordinate X is NOT correct!");
        softAssert.assertEquals(actualY, coordinateY,
                "Coordinate Y is NOT correct!");
        softAssert.assertAll();
    }

    @Then("^the rover is facing towards (north|east|south|west)$")
    public void theRoverIsFacingTowardsDirection(String facing) {
        var actualDirection = controller.getDirection();
        int direction = 0;
        switch (facing) {
            case "north":
                direction = 1;
                break;
            case "east":
                direction = 2;
                break;
            case "south":
                direction = 3;
                break;
            case "west":
                direction = 4;
                break;
        }
        Assert.assertEquals(actualDirection, direction,
                "Direction is NOT correct!");
    }

    @Then("the rover is out of coordination boundary")
    public void theRoverIsOutOfCoordinationBoundary() {

        softAssert.assertFalse(controller.flagOutOfBoundary);
    }

    @Then("the rover should not be able to move the negative x and y coordination zone")
    public void theRoverShouldNotBeAbleToMoveTheNegativeXAndYCoordinationZone() {

        softAssert.assertFalse(controller.flagNegativeCoordination);
        softAssert.assertAll();
        System.out.println("Navigator can't order negative x and y unit as the initial coordination");

    }

    @Then("the rover should be able to move in the positive x and y coordination zone")
    public void theRoverShouldBeAbleToMoveInThePositiveXAndYCoordinationZone() {

        softAssert.assertTrue(controller.flagNegativeCoordination);
        softAssert.assertAll();
    }

    @Then("^the navigator orders only one command of turn (left|right)$")
    public void theNavigatorOrdersOnlyOneCommandOfTurn(String direction) {
        switch (direction) {
            case "left":
                controller.turnLeft();
                break;
            case "right":
                controller.turnRight();
                break;
            case "back":
                controller.turnBack();
                break;
        }
    }

    @When("the rover is settled at coordinates x = {int} and y = {int} facing = {int}")
    public void theRoverIsSettledAtCoordinatesXAndYFacing(int coordinateX, int coordinateY, int facing) {
        var actualX = controller.getAxisX();
        var actualY = controller.getAxisY();
        var actualFacing = controller.getDirection();

        softAssert.assertEquals(actualX, coordinateX,
                "Coordinate X is NOT correct!");
        softAssert.assertEquals(actualY, coordinateY,
                "Coordinate Y is NOT correct!");
        softAssert.assertEquals(actualFacing, facing,
                "Camera face direction is NOT correct!");
        softAssert.assertAll();
    }

    @Then("^the navigator orders only one command of move (\\d+) units (left|right|back|forward)$")
    public void theNavigatorOrdersASingleCommandOfMoveUnitsForward(int distance, String direction) {
        switch (direction) {
            case "left":
                controller.turnLeft();
                controller.move(distance);
                break;
            case "right":
                controller.turnRight();
                controller.move(distance);
                break;
            case "back":
                controller.turnBack();
                controller.move(distance);
                break;
            case "forward":
                controller.move(distance);
                break;
        }
    }

}

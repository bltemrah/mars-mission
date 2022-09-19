package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import navigation.Controller;

public class Hooks {

    // before starting test, get to know the first location
    @Before
    public void initialLocation(){
        System.out.println("First location: "
                + Controller.getPosition());
    }

    // print the final location
    @After
    public void finalLocation(Scenario scenario){
        System.out.println("Final location: "
                + Controller.getPosition());
        System.out.println("Status " + scenario.getStatus());
    }
}

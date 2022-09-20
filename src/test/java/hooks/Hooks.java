package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import navigation.Controller;

public class Hooks {

    
    @Before
    public void initialLocation(){
        System.out.println("Initial location: "
                + Controller.getPosition());
    }

  
    @After
    public void finalLocation(Scenario scenario){
        System.out.println("Final location: "
                + Controller.getPosition());
        System.out.println("Status " + scenario.getStatus());
    }
}

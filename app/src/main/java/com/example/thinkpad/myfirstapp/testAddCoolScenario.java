package com.example.thinkpad.myfirstapp;
import android.os.Bundle;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.AddPlantPopUps.CoolPopUp;
import com.example.thinkpad.myfirstapp.authenticator.DispatchActivity;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.AddPlantMenu;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.*;


public class testAddCoolScenario {

    boolean result = false;

    public void testAddCoolValid(){
        if(result)
            result = givenUserIsLoggedIn();
        if(result)
            result = whenUserClickToAddPlant();
        if(result)
            result = thenAddPlantMenuComesUp();
        if(result)
            result = whenUserClicksOnAdd();
        if(result)
            result = thenThePopUpComesUpAndPlantIsAdded();
    }

    // Accessor function.
    public boolean getResult(){
        return result;
    }

    // Function that tests if user is logged in.
    public boolean givenUserIsLoggedIn(){
        // Creating a new DispatchActivity object and calling the appropriate function to test.
        DispatchActivity testingLogIn = new DispatchActivity();
        testingLogIn.callOnCreate();
        return testingLogIn.getLogInFlag();
    }

    // Function that tests if user has clicked 'Add a Plant' from the main menu.
    public boolean whenUserClickToAddPlant(){
        // Creating a new MainMenuActivity object and calling the appropriate function to test.
        MainMenuActivity testingAddPlantButton = new MainMenuActivity();
        testingAddPlantButton.callOnCreate();
        return testingAddPlantButton.getAddPlantFlag();
    }

    // Function that tests if next page brings you to the Add Plant Menu.
    public boolean thenAddPlantMenuComesUp(){
        // Creating a new AddPlantMenu object and calling the appropriate function to test.
        AddPlantMenu testingAddingACoolPlant = new AddPlantMenu();
        testingAddingACoolPlant.callOnCreate();
        return testingAddingACoolPlant.getAddCoolPlantFlag();
    }

    // Function that tests if the user clicks on adding a cool plant after reading the description.
    public boolean whenUserClicksOnAdd(){
        // Creating a new AddCool object and calling the appropriate function to test.
        AddCool testingButtonFromDescription = new AddCool();
        testingButtonFromDescription.callOnCreate();
        return testingButtonFromDescription.getAddButtonPressedFlag();
    }

    // Function that tests that the pop-up comes up and plant was successfully added.
    public boolean thenThePopUpComesUpAndPlantIsAdded(){
        // Creating a new CoolPopUp object and calling the appropriate function to test.
        CoolPopUp testingPopUp = new CoolPopUp();
        testingPopUp.callOnCreate();
        return testingPopUp.getAddButtonPressedFromPopUpFlag();
    }
}

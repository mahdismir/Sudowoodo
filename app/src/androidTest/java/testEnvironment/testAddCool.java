package testEnvironment;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;
import android.widget.Button;
import android.widget.EditText;

import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.AddPlantPopUps.CoolPopUp;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.AddCool;
import com.example.thinkpad.myfirstapp.R;
import com.parse.ParseUser;

/**
 * Created by mitch_000 on 12/1/2015.
 */
public class testAddCool extends ActivityInstrumentationTestCase2<CoolPopUp> {

    // This is the constructor that will pull the CoolPopUp class
    public testAddCool() {super(CoolPopUp.class);}


    // Reference to dummy CoolPopUp activity
    private CoolPopUp testCoolPopUp;

    // Reference to "Nickname" EditText view
    private EditText nickname;

    // To imitate the user login
    private ParseUser testUser;

    private boolean userIsLoggedIn;


    // This function setups our environment.
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //testCoolPopUp = getActivity();

        //obtain a reference to the edit text for nickname
        //nickname = (EditText) testCoolPopUp.findViewById(R.id.plant_nickname);

        //fill it in with dummy data
        //nickname.setText("testNickname");
    }



    public void testAddPlantValid() throws Exception {

        givenUserIsLoggedin();
        //whenUserClickToAddAPlant();
        //thenInfoPageComesUp();
        //whenUserClicOnAdd();
        //thenThePopUpComesUp();
        //whenUserClicOnAddOnThePopUp();
        whenUserTypesNickname();
        //andClicksOnAddButton();
        //thenPlantIsCreatedInPlantList();

    }

    private void givenUserIsLoggedin() {
        // Create a dummy ParseUser with dummy name
        testUser = new ParseUser();
        testUser.setUsername("testUser");
        testUser.setPassword("abc");
    }

    private void whenUserTypesNickname(){
        assertEquals("testNickname",nickname.getText());
    }

    /*
    private void andClicksOnAddButton(){

    }
    private void whenUserClickToAddAPlant(){


//        //mimic user clicking add plant button
//
//        addcool = new AddCool();
//        Button btnAddCool = (Button) findViewById(R.id.coolbtn);
//        btnAddCool.performClick();
//
//        try {
//            if(addcool.isReturnvalue()){
//                part1 = true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            part1 = false;
//        }

    }

    private void thenInfoPageComesUp(){

    }
    private void whenUserClicOnAdd(){

    }
    private void thenThePopUpComesUp(){

    }
    private void whenUserClicOnAddOnThePopUp(){


    }
    private void thenPlantIsCreatedInPlantList(){


    }








    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    */
}

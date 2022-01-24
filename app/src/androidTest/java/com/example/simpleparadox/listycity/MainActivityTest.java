package com.example.simpleparadox.listycity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @Before
    public void setUp() {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    /**
     * Gets the Activity
     * @throws Exception
     */

   //Roll:1707067
    @Test
    public void checkList(){
    // Asserts that the current activity is the MainActivity. Otherwise, show “Wrong Activity”
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
    //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "DHAKA");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button
        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText
        //Roll:1707067
        assertTrue(solo.waitForText("DHAKA", 1, 2000));
        solo.clickLongInList(0);
        solo.clickOnButton("Back");
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
        solo.enterText((EditText) solo.getView(R.id.editText_name), "DHAKA");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button
        assertTrue(solo.waitForText("DHAKA", 1, 2000));
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
        solo.enterText((EditText) solo.getView(R.id.editText_name), "KHULNA");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button
        assertTrue(solo.waitForText("KHULNA", 1, 2000));
        solo.clickOnButton("ClEAR ALL"); //Select ClEAR ALL
        //True if there is no text: Edmonton on the screen
        assertFalse(solo.searchText("KHULNA"));
    }

    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }


}



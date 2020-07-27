package kiz.learnwithvel.yelinc.ui.register;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kiz.learnwithvel.yelinc.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static kiz.learnwithvel.yelinc.Utilities.INVALID_EMAIL;
import static kiz.learnwithvel.yelinc.Utilities.INVALID_PASSWORD;
import static kiz.learnwithvel.yelinc.Utilities.VALID_EMAIL;
import static kiz.learnwithvel.yelinc.Utilities.VALID_PASSWORD;

@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {


    @Rule
    public ActivityTestRule<RegisterActivity> testRule = new ActivityTestRule<>(RegisterActivity.class);


    @Test
    public void enterEmail_checkIsEmpty() {
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
    }

    @Test
    public void enterEmailPassword_checkIsEmpty() {
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
    }

    @Test
    public void enterEmailPasswordConfirm_checkIsEmpty() {
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(INVALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
    }

    @Test
    public void enterInvalidEmail_checkIsValid() {
        onView(withId(R.id.register_email)).perform(typeText(INVALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
    }

    @Test
    public void enterInvalidPassword_checkIsValid() {
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(INVALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
    }

    @Test
    public void enterValidEmailPassword_checkIsValid() {
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
    }
}

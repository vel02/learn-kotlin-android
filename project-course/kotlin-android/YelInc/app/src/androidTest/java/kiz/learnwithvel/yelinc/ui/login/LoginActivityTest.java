package kiz.learnwithvel.yelinc.ui.login;

import android.os.RemoteException;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kiz.learnwithvel.yelinc.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static kiz.learnwithvel.yelinc.Utilities.CONFIRM_PASSWORD;
import static kiz.learnwithvel.yelinc.Utilities.INVALID_PASSWORD;
import static kiz.learnwithvel.yelinc.Utilities.VALID_EMAIL;
import static kiz.learnwithvel.yelinc.Utilities.VALID_PASSWORD;

/**
 * sources:
 * https://stackoverflow.com/questions/30867942/how-to-scroll-down-the-screen-in-the-android-espresso-test-i-need-to-validate-t
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void register() {

        onView(withId(R.id.login_register)).perform(click());
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(CONFIRM_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
        pressImeActionButton();
    }

    @Test
    public void login_invalid() throws RemoteException {

        UiDevice device = UiDevice.getInstance(getInstrumentation());

        onView(withId(R.id.login_register)).perform(click());
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(CONFIRM_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
        pressBack();


        onView(withId(R.id.login_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(INVALID_PASSWORD), closeSoftKeyboard());
        device.setOrientationRight();
        onView(withText("login")).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.login_login)).perform(click());
        device.setOrientationNatural();

    }

    @Test
    public void login_valid() throws RemoteException {

        UiDevice device = UiDevice.getInstance(getInstrumentation());

        onView(withId(R.id.login_register)).perform(click());
        onView(withId(R.id.register_email)).perform(typeText(VALID_EMAIL));
        onView(withId(R.id.register_password)).perform(typeText(VALID_PASSWORD));
        onView(withId(R.id.register_confirm_password)).perform(typeText(CONFIRM_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.register_register)).perform(click());
        pressBack();


        onView(withId(R.id.login_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        device.setOrientationRight();
        onView(withText("login")).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.login_login)).perform(click());
        device.setOrientationNatural();

    }
}

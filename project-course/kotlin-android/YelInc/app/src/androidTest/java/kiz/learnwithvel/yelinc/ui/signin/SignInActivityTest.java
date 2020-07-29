package kiz.learnwithvel.yelinc.ui.signin;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiSelector;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.Utilities;
import kiz.learnwithvel.yelinc.ui.signedin.SignedInActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static kiz.learnwithvel.yelinc.Utilities.VALID_EMAIL;
import static kiz.learnwithvel.yelinc.Utilities.VALID_PASSWORD;

/**
 * source:
 * https://stackoverflow.com/questions/54375039/how-to-click-android-phone-home-button-programmatically-in-espresso
 * https://i1.wp.com/swipetips.com/wp-content/uploads/2019/09/home-screen.jpg?resize=532%2C851&ssl=1
 * https://stackoverflow.com/questions/40363391/click-on-menu-item-that-is-sometimes-in-the-overflow-menu/40864574#40864574
 * https://stackoverflow.com/questions/23293301/how-to-regain-access-on-a-activity-after-sending-it-to-background3
 * https://stackoverflow.com/questions/40088210/espresso-test-how-to-open-my-application-back-after-opening-the-recent-apps
 * https://stackoverflow.com/questions/32112673/swiping-to-next-page-in-uiautomator
 */
@RunWith(AndroidJUnit4.class)
public class SignInActivityTest {

    @Rule
    public ActivityTestRule<SignedInActivity> activityTestRule = new ActivityTestRule<>(SignedInActivity.class);

    public static Matcher<View> withMenuIdOrText(@IdRes int menuId, @StringRes int menuText) {
        Matcher<View> matcher = withId(menuId);
        try {
            onView(matcher).check(matches(isDisplayed()));
            return matcher;
        } catch (Exception NoMatchingViewException) {
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
            return withText(menuText);
        }
    }

    @Test
    public void rotateLogout() throws Exception {

        UiDevice device = UiDevice.getInstance(getInstrumentation());

        //login
        onView(withId(R.id.login_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_login)).perform(click());

        //rotate
        device.setOrientationRight();

        //logout
        onView(withMenuIdOrText(R.id.action_logout, R.string.menu_label_logout)).perform(click());

        //rotate
        device.setOrientationNatural();

    }

    @Test
    public void device_homeRecentApp() throws Exception {
        UiDevice device = UiDevice.getInstance(getInstrumentation());

        //login
        onView(withId(R.id.login_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_login)).perform(click());

        //background/pause
        device.pressHome();

        //foreground/restart
        device.pressRecentApps();
        device.findObject(new UiSelector().descriptionContains(Utilities.APP_NAME_DESCRIPTION)).click();

        //logout
        onView(withMenuIdOrText(R.id.action_logout, R.string.menu_label_logout)).perform(click());

    }

    @Test
    public void device_backRecentApp() throws Exception {
        UiDevice device = UiDevice.getInstance(getInstrumentation());

        //login
        onView(withId(R.id.login_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_login)).perform(click());

        //background/close
        device.pressBack();

        //foreground/open
        device.pressRecentApps();
        device.findObject(new UiSelector().descriptionContains(Utilities.APP_NAME_DESCRIPTION)).click();

        //logout
        onView(withMenuIdOrText(R.id.action_logout, R.string.menu_label_logout)).perform(click());

    }

    @Test
    public void device_findApp() throws Exception {
        UiDevice device = UiDevice.getInstance(getInstrumentation());

        //remove
        device.pressBack();
        device.pressRecentApps();
        device.findObject(new UiSelector().descriptionContains(Utilities.APP_NAME_DESCRIPTION)).swipeUp(100);

        //find
        device.swipe(700, 2000, 700, 0, 100);
        device.findObject(new UiSelector().text(Utilities.APP_NAME_DESCRIPTION)).click();
    }

    @Test
    public void device_login_removeFindLogout() throws Exception {

        UiDevice device = UiDevice.getInstance(getInstrumentation());

        //login
        onView(withId(R.id.login_email)).perform(typeText(VALID_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_login)).perform(click());

        //remove
        device.pressBack();
        device.pressRecentApps();
        device.findObject(new UiSelector().descriptionContains(Utilities.APP_NAME_DESCRIPTION)).swipeUp(100);

        //find
        device.swipe(700, 2000, 700, 0, 100);
        device.findObject(new UiSelector().text(Utilities.APP_NAME_DESCRIPTION)).click();

        //logout
        onView(withMenuIdOrText(R.id.action_logout, R.string.menu_label_logout)).perform(click());
    }
}

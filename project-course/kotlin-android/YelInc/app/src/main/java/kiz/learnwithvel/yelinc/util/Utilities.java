package kiz.learnwithvel.yelinc.util;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import static android.text.TextUtils.isEmpty;
import static kiz.learnwithvel.yelinc.util.Constants.VALID_DOMAIN;

public class Utilities {

    public static class Field {
        private Field() {
        }

        public static boolean areFieldEmpty(java.lang.String email, java.lang.String password, java.lang.String confirm) {
            return !isEmpty(email) && !isEmpty(password) && !isEmpty(confirm);
        }

        public static boolean isValid(String email) {
            return email.substring(email.indexOf('@') + 1).equals(VALID_DOMAIN);
        }

        public static boolean isMatch(String password, String confirm) {
            return password.equals(confirm);
        }
    }

    public static class Message {
        private Message() {
        }

        public static void showMessage(View view, String message) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
        }
    }

}

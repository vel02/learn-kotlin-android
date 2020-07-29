package kiz.learnwithvel.yelinc.model;

import android.net.Uri;

import androidx.annotation.NonNull;

public class User {

    private String uid;
    private String name;
    private String email;
    private Uri photo;

    public User(String uid, String name, String email, Uri photo) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.photo = photo;
    }

    public User() {
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + photo +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }
}

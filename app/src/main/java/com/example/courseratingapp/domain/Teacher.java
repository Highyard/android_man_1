package com.example.courseratingapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Teacher implements Parcelable {

    private String name;
    private String email;

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
    }

    protected Teacher(Parcel in) {
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
    }
}

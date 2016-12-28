package com.example.anusha.contactsap_;
import java.io.Serializable;


public class Contacts implements Serializable {

    private String Name, Email, Number;
    private int mImageId;

    public Contacts(String name, String email, String number, int imageId) {
        this.Name = name;
        this.Email = email;
        this.Number = number;
        this.mImageId = imageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }
}



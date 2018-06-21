package com.example.vbhw5926.manageroom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

/**
 * Created by VIBHU on 6/11/2018.
 */

public class Details extends AppCompatButton {
    private String name;
    private String email;
    private String phoneNo;
    private String UserId;
    private String Slot;
    private String Avail;
    private int i;
    private int j;
    private String room;

    public Details(Context context) {
        super(context);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String getAvail() {
        return Avail;
    }

    public void setAvail(String avail) {
        Avail = avail;
    }

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String slot) {
        Slot = slot;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}


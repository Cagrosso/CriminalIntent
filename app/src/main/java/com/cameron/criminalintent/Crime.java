package com.cameron.criminalintent;

import java.util.UUID;

/**
 * Created by Cameron on 11/6/14.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Crime(){
        //Generate unique identifier
        mId = UUID.randomUUID();
    }
}

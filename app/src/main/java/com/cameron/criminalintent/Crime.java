package com.cameron.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Cameron on 11/6/14.
 * This is the Crime data type that holds all of the data for a single instance of crime.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Crime(){
        //Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString(){
        return mTitle;
    }
}

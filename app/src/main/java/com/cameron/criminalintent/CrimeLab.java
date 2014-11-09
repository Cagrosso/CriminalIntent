package com.cameron.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Cameron on 11/8/14.
 * This is the singleton that contains all of the crime instances in an arraylist
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private ArrayList<Crime> mCrimes;

    private CrimeLab (Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();

        //Generate fake crimes
        for(int i = 0; i < 100; i++){
            Crime c = new Crime();
            c.setmTitle("Crime #" + i);
            c.setmSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getmCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : mCrimes){
            if (c.getmId().equals(id))
                return c;
        }
        return null;
    }

}

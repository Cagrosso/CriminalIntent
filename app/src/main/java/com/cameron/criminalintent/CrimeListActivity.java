package com.cameron.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Cameron on 11/8/14.
 * This is the Crime List that displays the fragment that holds all of the crimes in a list
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}

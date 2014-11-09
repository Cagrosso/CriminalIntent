package com.cameron.criminalintent;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cameron on 11/8/14.
 * This is the list fragment that displays the new adapter that shows the date, title, and solved checkbox
 * of all the crimes in the list.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getmCrimes();

       CrimeAdapter adapter = new CrimeAdapter(mCrimes);
       setListAdapter(adapter);

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);

        //Start CrimeActivity
        Intent i = new Intent(getActivity(), CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
        startActivity(i);
    }

    private class CrimeAdapter extends ArrayAdapter<Crime>{

        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if (convertView == null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);
            }

            Crime c = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getmTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getmDate().toString());

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.ismSolved());

            return convertView;
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }
}

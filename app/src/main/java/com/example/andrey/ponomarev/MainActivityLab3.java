package com.example.andrey.ponomarev;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivityLab3 extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_lab3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void lab3ToggleButtonClick(View view) {
        ProgressBar progressBar=(ProgressBar)findViewById(R.id.lab3ProgressBar2);
        ToggleButton toggleButton=(ToggleButton)findViewById(R.id.lab3ToggleButton);
        if(toggleButton.isChecked()) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.INVISIBLE);
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    implements SeekBar.OnSeekBarChangeListener{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        TextView textView;
        ConstraintLayout constraintLayout;
        int red=0,green=0,blue=0;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_activity_lab3, container, false);

            textView = (TextView) rootView.findViewById(R.id.lab3TextColorInfo);
            constraintLayout = (ConstraintLayout)rootView.findViewById(R.id.lab3ConstLayout);
            SeekBar seekBarRed =(SeekBar)rootView.findViewById(R.id.lab3SeekBarRed);
            SeekBar seekBarGreen =(SeekBar)rootView.findViewById(R.id.lab3SeekBarGreen);
            SeekBar seekBarBlue =(SeekBar)rootView.findViewById(R.id.lab3SeekBarBlue);

            seekBarRed.setOnSeekBarChangeListener(this);
            seekBarGreen.setOnSeekBarChangeListener(this);
            seekBarBlue.setOnSeekBarChangeListener(this);

            return rootView;
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            switch (seekBar.getId())
            {
                case R.id.lab3SeekBarRed: red=progress; break;
                case R.id.lab3SeekBarGreen: green=progress; break;
                case R.id.lab3SeekBarBlue: blue=progress; break;
            }
            textView.setText("("+red+", "+green+", "+blue+")");
            textView.setTextColor(Color.rgb(255-red,255-green,255-blue));
            constraintLayout.setBackgroundColor(Color.rgb(red,green,blue));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //textView.setText("()");
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0: return  PlaceholderFragment.newInstance(position+1);
                case 1: return  MainActivityLab3_2.newInstance();
            }
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Задание 1";
                case 1:
                    return "Задание 2";
            }
            return null;
        }
    }
}

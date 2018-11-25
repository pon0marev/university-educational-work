package com.example.andrey.ponomarev;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;

import java.io.IOException;
import java.io.InputStream;

public class MainActivityLab6 extends AppCompatActivity {


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
        setContentView(R.layout.activity_main_lab6);

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
        getMenuInflater().inflate(R.menu.menu_main_activity_lab6, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements AdapterView.OnItemSelectedListener{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        final String[] auto = new String[] {
                "Audi", "BMW", "Fiat", "Ford",
                "Honda", "Hyndai", "Infinity", "KIA", "Lexus",
                "Renault", "Subaru", "Toyota"
        };
        final String[] carImage = new String[] {
                "AudiSQ7", "BMWX4", "FiatTipo", "FordGalaxy", "HondaFit",
                "HyundaiGenesis", "InfinitiJX", "KIAOptima", "LexusLC", "RenaultLogan",
                "SubaruXV", "ToyotaYaris"
        };
        ArrayAdapter<String> arrayAdapter;
        ImageView imageView;
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

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_activity_lab6, container, false);

            imageView=(ImageView)rootView.findViewById(R.id.lab6Image);
            Spinner spinner=(Spinner)rootView.findViewById(R.id.lab6Spinner);
            spinner.setOnItemSelectedListener(this);
            arrayAdapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1,auto);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner.setAdapter(arrayAdapter);

            return rootView;
        }


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            InputStream inputStream = null;
            try {
                inputStream = getContext().getAssets().open("images/" + carImage[position]+".jpg");
                Drawable d = Drawable.createFromStream(inputStream, null);
                imageView.setImageDrawable(d);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        private class AutoAdapter extends ArrayAdapter{

            public AutoAdapter(@NonNull Context context, @LayoutRes int resource) {
                super(context, resource);
            }

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
            switch (position){
                case 0: return PlaceholderFragment.newInstance(position+1);
                case 1: return MainActivityLab6_2.newInstance();
            }
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Задание 1";
                case 1: return "Задание 2";
            }
            return null;
        }
    }
}

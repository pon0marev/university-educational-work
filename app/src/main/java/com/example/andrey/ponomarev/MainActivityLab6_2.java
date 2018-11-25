package com.example.andrey.ponomarev;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityLab6_2 extends Fragment {


    public MainActivityLab6_2() {
        // Required empty public constructor
    }
    public static MainActivityLab6_2 newInstance() {

        return new MainActivityLab6_2();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_activity_lab6_2, container, false);
    }

}

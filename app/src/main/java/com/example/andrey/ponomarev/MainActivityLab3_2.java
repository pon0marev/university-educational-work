package com.example.andrey.ponomarev;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainActivityLab3_2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainActivityLab3_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityLab3_2 extends Fragment
implements CompoundButton.OnCheckedChangeListener{


    private OnFragmentInteractionListener mListener;

    public MainActivityLab3_2() {
        // Required empty public constructor
    }


    public static MainActivityLab3_2 newInstance(){
        return new MainActivityLab3_2();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main_activity_lab3_2, container, false);
        progressBar=(ProgressBar)rootView.findViewById(R.id.lab3ProgressBar1);
        Switch aSwitch =(Switch)rootView.findViewById(R.id.lab3Switch);
        aSwitch.setOnCheckedChangeListener(this);
        return rootView;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.INVISIBLE);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
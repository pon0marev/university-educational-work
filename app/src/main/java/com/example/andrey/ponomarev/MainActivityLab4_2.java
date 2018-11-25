package com.example.andrey.ponomarev;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainActivityLab4_2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainActivityLab4_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityLab4_2 extends Fragment
implements RadioGroup.OnCheckedChangeListener{

    private OnFragmentInteractionListener mListener;

    public MainActivityLab4_2() {
        // Required empty public constructor
    }

    public static MainActivityLab4_2 newInstance() {

        return new MainActivityLab4_2();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_main_activity_lab4_2, container, false);
        imageView=(ImageView)rootView.findViewById(R.id.lab4ImageForRadioButton);
        RadioGroup radioGroup=(RadioGroup)rootView.findViewById(R.id.lab4RadioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        return rootView;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId)
        {
            case R.id.lab4RadioButtonA4: imageView.setImageResource(R.drawable.a4); break;
            case R.id.lab4RadioButtonA5: imageView.setImageResource(R.drawable.a5); break;
            case R.id.lab4RadioButtonA6: imageView.setImageResource(R.drawable.a6); break;
        }
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

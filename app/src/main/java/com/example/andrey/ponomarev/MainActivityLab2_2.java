package com.example.andrey.ponomarev;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainActivityLab2_2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainActivityLab2_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityLab2_2 extends Fragment
implements View.OnKeyListener {


    private OnFragmentInteractionListener mListener;

    public MainActivityLab2_2() {
        // Required empty public constructor
    }


    public static MainActivityLab2_2 newInstance(){
        return new MainActivityLab2_2();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_main_activity_lab2_2, container, false);

        EditText enterText = (EditText)rootView.findViewById(R.id.editText);
        enterText.setOnKeyListener(this);
        showText = (TextView)rootView.findViewById(R.id.textOut);


        return rootView;

    }





    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    TextView showText;
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

            showText.setText("Введен символ: "+ (char)event.getUnicodeChar());


        return false;
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

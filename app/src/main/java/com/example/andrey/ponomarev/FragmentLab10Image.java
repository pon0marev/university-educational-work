package com.example.andrey.ponomarev;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


public class FragmentLab10Image extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    public FragmentLab10Image() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_fragment_lab10_image, container, false);;
        return inflater.inflate(R.layout.fragment_fragment_lab10_image, container, false);
    }


    public void setImage(String src){
        ImageView imageView=(ImageView)getView().findViewById(R.id.imageView);
        InputStream inputStream = null;
        try{
            inputStream = getContext().getAssets().open("images/"+src+".jpg");
            Drawable d = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(d);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(inputStream!=null)
                    inputStream.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

}

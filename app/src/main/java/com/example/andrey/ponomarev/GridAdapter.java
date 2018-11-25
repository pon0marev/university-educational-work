package com.example.andrey.ponomarev;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


class GridAdapter extends BaseAdapter {
    Context context;
    String[] image;

    int layout;
    private LayoutInflater mLayoutInflater;

    GridAdapter(Context context, int layout, String[] image) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context=context;
        this.layout=layout;
        this.image=image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = mLayoutInflater.inflate(layout, null);

        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);

        InputStream inputStream = null;
        try{
            inputStream = context.getAssets().open("images/"+this.image[position]+".jpg");
            Drawable d = Drawable.createFromStream(inputStream, null);
            image.setImageDrawable(d);
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

        return convertView;
    }
    String getString(int position) {
        return image[position];
    }
}

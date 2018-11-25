package com.example.andrey.ponomarev;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityLab5_2 extends Fragment
implements AdapterView.OnItemClickListener{


    public MainActivityLab5_2() {
        // Required empty public constructor
    }
    public static MainActivityLab5_2 newInstance() {

        return new MainActivityLab5_2();
    }

    final String[] auto = new String[] {
            "Audi A4", "Audi A5", "Audi A6" };
    final int[] autoImage=new int[]{
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6
    };

    private AutomobileAdapter automobileAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_main_activity_lab5_2, container, false);
        final ListView listView = (ListView)rootView.findViewById(R.id.lab5ListAuto);

        automobileAdapter = new AutomobileAdapter(getContext());
        listView.setAdapter(automobileAdapter);
        listView.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context=getContext();
        Intent intent = new Intent(context, MainActivityLab5_2Info.class);
        intent.putExtra("position",position);
        context.startActivity(intent);

    }

    private class AutomobileAdapter extends BaseAdapter{
        private LayoutInflater mLayoutInflater;

        AutomobileAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return auto.length;
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
                convertView = mLayoutInflater.inflate(R.layout.ico_and_text, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.icon);
            image.setImageResource(autoImage[position]);

            TextView signTextView = (TextView) convertView.findViewById(R.id.label);
            signTextView.setText(auto[position]);

            return convertView;
        }
        String getString(int position) {
            return auto[position]+"";
        }
    }
}

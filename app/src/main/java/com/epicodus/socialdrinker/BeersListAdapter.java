package com.epicodus.socialdrinker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BeersListAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBeers;
    private String[] mStyles;
    private Typeface mTypeface;

    public BeersListAdapter(Context mContext, int resource, String[] mBeers, String[] mStyles, Typeface typeface) {
        super(mContext ,resource);
        this.mContext = mContext;
        this.mBeers = mBeers;
        this.mStyles = mStyles;
        this.mTypeface = typeface;
    }

    @Override
    public Object getItem(int position) {
        String beer = mBeers[position];
        String style = mStyles[position];
        return String.format("%s \n %s", beer, style);

    }

    @Override
    public int getCount() {
        return mBeers.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =super.getView(position, convertView, parent);

        TextView textView=(TextView) view.findViewById(android.R.id.text1);

        textView.setTextColor(Color.WHITE);
        textView.setTypeface(mTypeface);
        textView.setBackgroundColor(Color.DKGRAY);
        return view;
    }
}

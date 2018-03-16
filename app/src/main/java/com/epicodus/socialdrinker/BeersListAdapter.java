package com.epicodus.socialdrinker;

import android.content.Context;
import android.widget.ArrayAdapter;

public class BeersListAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBeers;
    private String[] mStyles;

    public BeersListAdapter(Context mContext, int resource, String[] mBeers, String[] mStyles) {
        super(mContext ,resource);
        this.mContext = mContext;
        this.mBeers = mBeers;
        this.mStyles = mStyles;
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
}

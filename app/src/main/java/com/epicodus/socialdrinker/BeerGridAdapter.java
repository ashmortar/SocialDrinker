package com.epicodus.socialdrinker;


import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class BeerGridAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mBeers;
    private String[] mStyles;
    private Typeface mTypeface;

    public BeerGridAdapter (Context context, String[] beers, String[] styles, Typeface typeface){
        this.mContext = context;
        this.mBeers = beers;
        this.mStyles = styles;
        this.mTypeface = typeface;

    }

    @Override
    public int getCount() {
        return mBeers.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        final String beer = mBeers[i];
        final String style = mStyles[i];

        if (view == null) {
            //get layout from xml file
            gridView = inflater.inflate(R.layout.beer_grid_item, null);

            //pull views
            TextView beerView = (TextView) gridView
                    .findViewById(R.id.grid_item_beer);
            beerView.setTypeface(mTypeface);

            //set values
            beerView.setText(mBeers[i]);
            beerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, style, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            gridView = (View) view;
        }
        return gridView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}

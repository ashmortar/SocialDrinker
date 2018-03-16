package com.epicodus.socialdrinker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

import butterknife.BindView;

public class GridActivity extends AppCompatActivity {
    GridView gridView;
    private String[] beers = new String[] {"Juice Jr", "Oregon Native", "Avatar Jasmine", "Trumpet Major", "Duo", "Pimp My Sleigh", "The DAB Lab, Hop Hash", "The Terry Porter"};
    private String[] styles = new String[] {"IPA - New England", "Saison/Farmhouse Ale", "IPA - American", "Burton Ale", "Lambic - fruit", "Belgian Strong Dark Ale", "IPA - American", "Porter - American"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Typeface roboto = Typeface.DEFAULT.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new BeerGridAdapter(this, beers, styles, roboto));




    }
}

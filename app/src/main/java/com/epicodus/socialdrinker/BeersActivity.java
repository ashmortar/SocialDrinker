package com.epicodus.socialdrinker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BeersActivity extends AppCompatActivity {
    public static final String TAG = BeersActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] beers = new String[] {"Juice Jr", "Oregon Native", "Avatar Jasmine", "Trumpet Major", "Duo", "Pimp My Sleigh", "The DAB Lab, Hop Hash", "The Terry Porter"};
    private String[] styles = new String[] {"IPA - New England", "Saison/Farmhouse Ale", "IPA - American", "Burton Ale", "Lambic - fruit", "Belgian Strong Dark Ale", "IPA - American", "Porter - American"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);
        Typeface roboto = Typeface.DEFAULT.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        BeersListAdapter adapter = new BeersListAdapter(this, android.R.layout.simple_list_item_1, beers, styles, roboto);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String beer = ((TextView)view).getText().toString();
                Toast.makeText(BeersActivity.this, beer, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the beers near: " + location);
    }
}

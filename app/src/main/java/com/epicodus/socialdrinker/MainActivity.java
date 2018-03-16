package com.epicodus.socialdrinker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.beerMeButton) Button mBeerMeButton;
    @BindView(R.id.showGridButton) Button mShowGridButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface roboto = Typeface.DEFAULT.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        mAppNameTextView.setTypeface(roboto);

        mBeerMeButton.setOnClickListener(this);
        mShowGridButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mBeerMeButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, BeersActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }

        if (view == mShowGridButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, GridActivity.class);
            startActivity(intent);
        }

    }
}

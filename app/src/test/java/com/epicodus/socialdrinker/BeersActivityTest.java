package com.epicodus.socialdrinker;

import android.os.Build;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)

public class BeersActivityTest {
    private BeersActivity activity;
    private ListView mBeersListView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(BeersActivity.class);
        mBeersListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void beersListViewPopulates() throws Exception {
        assertNotNull(mBeersListView.getAdapter());
        assertEquals(mBeersListView.getAdapter().getCount(), 8);
    }
}
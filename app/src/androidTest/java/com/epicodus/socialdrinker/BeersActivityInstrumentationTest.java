package com.epicodus.socialdrinker;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

public class BeersActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<BeersActivity> activityTestRule =
            new ActivityTestRule<>(BeersActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectBeer() throws Exception {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String beerName = "Juice Jr Unfiltered IPA";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        Espresso.onView(withText(beerName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(beerName)));
    }
}

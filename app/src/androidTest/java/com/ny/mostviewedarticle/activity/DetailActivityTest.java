package com.ny.mostviewedarticle.activity;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.ny.mostviewedarticle.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DetailActivityTest {

    private DetailActivity detailActivity = null;

    @Rule
    public ActivityTestRule<DetailActivity> activityTestRule = new ActivityTestRule<>(DetailActivity.class);

    @Before
    public void setUp() throws Exception {
        detailActivity = activityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view1 = detailActivity.findViewById(R.id.wvDetails);
        assertNotNull(view1);
    }

    @After
    public void tearDown() throws Exception {
        detailActivity = null;
    }
}

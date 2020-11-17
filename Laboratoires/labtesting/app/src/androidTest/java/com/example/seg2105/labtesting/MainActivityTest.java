package com.example.seg2105.labtesting;

import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;
    private TextView text;

    @Before
    public void setUp() throws Exception{
        mActivity= mActTestRule.getActivity();
    }

    @Test
    @UiThreadTest
    public void checkFirstName()throws Exception{
        assertNotNull(mActivity.findViewById(R.id.textView1));
        text= mActivity.findViewById(R.id.username);
        text.setText("user1");
        String name= text.getText().toString();
        assertNotEquals("user",name);
    }

    @Test
    @UiThreadTest
    public void checkLastName()throws Exception{
        assertNotNull(mActivity.findViewById(R.id.textView1));
        text= mActivity.findViewById(R.id.Lastname);
        text.setText("test1");
        String name= text.getText().toString();
        assertNotEquals("user",name);
    }

    @Test
    @UiThreadTest
    public void checkPassword()throws Exception{
        assertNotNull(mActivity.findViewById(R.id.textView1));
        text= mActivity.findViewById(R.id.password);
        text.setText("admin1");
        String name= text.getText().toString();
        assertNotEquals("user",name);
    }
}

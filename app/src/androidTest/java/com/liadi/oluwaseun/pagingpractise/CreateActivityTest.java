package com.liadi.oluwaseun.pagingpractise;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class CreateActivityTest {

    @Rule
    public ActivityTestRule<CreateActivity> intentsTestRule = new ActivityTestRule<>(CreateActivity.class);
    @Test
    public void button_should_be_displayed(){
        onView(withId(R.id.save_todo)).check(matches(isDisplayed()));
    }

    @Test
    public void textField_should_contain_text(){
        onView(withId(R.id.save_todo)).check(matches(withText("Add")));
    }

    @Test
    public void should_save_entry_to_db(){
        onView(withId(R.id.todo_text)).perform(typeText("Practise Instrumentation test"));
        onView(withId(R.id.save_todo)).perform(click());
    }
}

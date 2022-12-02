package com.pragma.democatbreed.features.breeds.views


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.pragma.democatbreed.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTestTitleShow {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTitleShow() {
        val textView = onView(
            allOf(
                withText("demojenkinsapp"),
                withParent(
                    allOf(
                        withId(R.id.action_bar),
                        withParent(withId(R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("demojenkinsapp")))
    }
}

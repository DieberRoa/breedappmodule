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
class MainActivityTestFirstElementShow {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTestFirstElementShow() {
        val textView = onView(
            allOf(
                withId(R.id.textname), withText("Anteojos binoculares"),
                withParent(withParent(withId(R.id.recyclerstuffs))),
                isDisplayed()
            )
        )

        Thread.sleep(3000)

        textView.check(matches(withText("Anteojos binoculares")))
    }
}

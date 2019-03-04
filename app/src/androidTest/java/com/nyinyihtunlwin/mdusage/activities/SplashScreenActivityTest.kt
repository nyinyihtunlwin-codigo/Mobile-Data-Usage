package com.nyinyihtunlwin.mdusage.activities

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class SplashScreenActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<SplashScreenActivity>(
        SplashScreenActivity::class.java
    )

    @Test
    fun goToMainScreen() {
        try {
            Thread.sleep(60000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        MainActivity.newInstnace(activityRule.activity)
    }
}
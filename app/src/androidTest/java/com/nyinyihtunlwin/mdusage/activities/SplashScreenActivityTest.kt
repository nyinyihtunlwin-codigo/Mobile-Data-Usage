package com.nyinyihtunlwin.mdusage.activities

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SplashScreenActivityTest {
    @Rule @JvmField
    var mActivityRule = ActivityTestRule(SplashScreenActivity::class.java)

    @Test
    fun goToMainActivity() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        MainActivity.newInstnace(mActivityRule.activity.applicationContext)
    }
}
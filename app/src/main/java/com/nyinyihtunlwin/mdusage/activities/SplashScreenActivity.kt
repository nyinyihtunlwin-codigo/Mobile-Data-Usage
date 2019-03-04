package com.nyinyihtunlwin.mdusage.activities

import android.os.Bundle
import android.os.Handler
import com.nyinyihtunlwin.mdusage.R

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            startActivity(MainActivity.newInstnace(applicationContext))
        }, 2000)
    }
}

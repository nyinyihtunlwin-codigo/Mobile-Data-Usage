package com.nyinyihtunlwin.mdusage

import android.app.Application
import com.nyinyihtunlwin.mdusage.data.models.MDUModel

class MDUApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        MDUModel.getInstance().initDatabase(applicationContext)
    }
}
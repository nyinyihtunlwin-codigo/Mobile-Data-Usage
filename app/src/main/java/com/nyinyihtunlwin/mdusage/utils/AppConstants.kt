package com.nyinyihtunlwin.mdusage.utils

class AppConstants {
    companion object {
        val BASE_URL = "https://data.gov.sg/"
        var lastDataValue = 0.0
        var tmpRecList: ArrayList<Double> = ArrayList()
        var tmpMap : HashMap<Int,Double> = HashMap()
        const val TABLE_RECORDS = "records"
    }
}
package com.nyinyihtunlwin.mdusage.data.vos

class YearDUsageVO{
    var year : Int? = 0
    var q1 : QuarterDUsageVO? = null
    var q2 : QuarterDUsageVO? = null
    var q3 : QuarterDUsageVO? = null
    var q4 : QuarterDUsageVO? = null

    fun setQuarterData(quarter : String, usage : QuarterDUsageVO){
        when(quarter){
            "Q1" -> q1 = usage
            "Q2" -> q2 = usage
            "Q3" -> q3 = usage
            "Q4" -> q4 = usage
        }
    }
}
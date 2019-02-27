package com.nyinyihtunlwin.mdusage.mvp.views

import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO

interface MDUView {
    fun showPrompt(message: String)
    fun showLoading()
    fun hideLoading()
    fun displayAnnualRecordLists(appList: MutableList<YearDUsageVO>)
}
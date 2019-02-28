package com.nyinyihtunlwin.mdusage.data.models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.nyinyihtunlwin.mdusage.data.vos.QuarterDUsageVO
import com.nyinyihtunlwin.mdusage.data.vos.RecordVO
import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO
import com.nyinyihtunlwin.mdusage.persistence.MDUDatabase
import com.nyinyihtunlwin.mdusage.utils.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MDUModel : BaseModel() {

    private lateinit var mDUsageDisposable: Disposable

    companion object {
        private var INSTANCE: MDUModel? = null
        fun getInstance(): MDUModel {
            if (INSTANCE == null) {
                INSTANCE = MDUModel()
            }
            val i = INSTANCE
            return i!!
        }
    }

    fun initDatabase(context: Context) {
        mDatabase = MDUDatabase.getDatabase(context)
    }

    fun getDataUsage(): List<YearDUsageVO> {
       return getAnnualRecords(mDatabase.mduDao().getRecords())
    }

    fun startLoadingDataUsage(
        resourceId: String,
        responseLD: MutableLiveData<List<YearDUsageVO>>,
        errorLd: MutableLiveData<String>
    ) {
        mDUsageDisposable = mApi.getMobileDataUsage(resourceId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it != null && it.isSuccess) {
                    if (it.result != null && it.result.records!!.isNotEmpty()) {
                        AppConstants.lastDataValue = 0.0
                        responseLD.value = getAnnualRecords(it.result.records)
                        mDatabase.mduDao().insertRecords(it.result.records)
                    }
                } else {
                    errorLd.value = "No data found."
                }
            }, {
                errorLd.value = it.localizedMessage
            }
            )
    }

    private fun getAnnualRecords(records: List<RecordVO>): List<YearDUsageVO> {
        val annualUsageList = ArrayList<YearDUsageVO>()
        for (record in records) {
            val recParts = record.quarter!!.split("-")
            val year = recParts[0].toInt()
            val quarter = recParts[1]


            if (year in 2008..2018) {
                val yearDUsage = YearDUsageVO()
                yearDUsage.year = year

                val quarterDUsage = QuarterDUsageVO(quarter, record.volOfMobileData!!.toDouble())
                yearDUsage.setQuarterData(quarter, quarterDUsage)

                var isExist = false
                for (annualRec in annualUsageList) {
                    if (annualRec.year == year) {
                        isExist = true
                        annualRec.setQuarterData(quarter, quarterDUsage)
                    }
                }
                if (!isExist) {
                    annualUsageList.add(yearDUsage)
                }
            }
        }
        return annualUsageList
    }

    fun disposeAll() {
        if (!mDUsageDisposable.isDisposed) {
            mDUsageDisposable.dispose()
        }
        MDUDatabase.destroyInstance()
    }
}
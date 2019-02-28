package com.nyinyihtunlwin.mdusage.mvp.presenters

import androidx.lifecycle.MutableLiveData
import com.nyinyihtunlwin.mdusage.data.models.MDUModel
import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO
import com.nyinyihtunlwin.mdusage.mvp.views.MDUView
import com.nyinyihtunlwin.mdusage.network.responses.MDUResponse
import com.nyinyihtunlwin.mdusage.utils.AppUtils

class MDUPresenter : BasePresenter<MDUView>() {

    lateinit var mResponseLD: MutableLiveData<List<YearDUsageVO>>

    override fun initPresenter(view: MDUView) {
        super.initPresenter(view)
        mResponseLD = MutableLiveData()
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    fun onGetDataUsage(resourceId: String) {
        if (MDUModel.getInstance().getDataUsage().isEmpty()) {
            if(AppUtils.getInstance().hasConnection()){
                mView!!.showLoading()
                MDUModel.getInstance().startLoadingDataUsage(resourceId, mResponseLD, mErrorLD)
            }else{
                mView!!.showPrompt("No internet connection!")
            }
        } else {
            mResponseLD.value = MDUModel.getInstance().getDataUsage()
        }
    }

    override fun onCleared() {
        super.onCleared()
        MDUModel.getInstance().disposeAll()
    }

    fun onRefreshDataUsage(resourceId: String) {
        if(AppUtils.getInstance().hasConnection()){
            mView!!.showLoading()
            MDUModel.getInstance().startLoadingDataUsage(resourceId, mResponseLD, mErrorLD)
        }else{
            mView!!.showPrompt("No internet connection!")
        }
    }
}
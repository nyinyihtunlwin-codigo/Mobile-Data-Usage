package com.nyinyihtunlwin.mdusage.mvp.presenters

import androidx.lifecycle.MutableLiveData
import com.nyinyihtunlwin.mdusage.data.models.MDUModel
import com.nyinyihtunlwin.mdusage.mvp.views.MDUView
import com.nyinyihtunlwin.mdusage.network.responses.MDUResponse

class MDUPresenter:BasePresenter<MDUView>() {

    lateinit var mResponseLD: MutableLiveData<MDUResponse>

    override fun initPresenter(view: MDUView) {
        super.initPresenter(view)
        mResponseLD = MutableLiveData()
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    fun onGetDataUsage(resourceId:String){
        MDUModel.getInstance().getDataUsage(resourceId,mResponseLD,mErrorLD)
    }

    override fun onCleared() {
        super.onCleared()
        MDUModel.getInstance().disposeAll()
    }
}
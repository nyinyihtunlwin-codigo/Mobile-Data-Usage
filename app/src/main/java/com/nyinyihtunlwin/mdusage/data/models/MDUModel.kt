package com.nyinyihtunlwin.mdusage.data.models

import androidx.lifecycle.MutableLiveData
import com.nyinyihtunlwin.mdusage.network.responses.MDUResponse
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

    fun getDataUsage(resourceId: String,
                             responseLD: MutableLiveData<MDUResponse>,
                             errorLd: MutableLiveData<String>) {
        mDUsageDisposable = mApi.getMobileDataUsage(resourceId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it!=null && it.isSuccess){
                    responseLD.value = it
                }else{
                    errorLd.value = "No data found."
                }
            },{
                errorLd.value = it.localizedMessage
            }
            )
    }

    fun disposeAll(){
        if(!mDUsageDisposable.isDisposed){
            mDUsageDisposable.dispose()
        }
    }
}
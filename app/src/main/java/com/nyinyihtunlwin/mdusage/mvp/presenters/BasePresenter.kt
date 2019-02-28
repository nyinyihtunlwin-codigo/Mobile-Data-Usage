package com.nyinyihtunlwin.mdusage.mvp.presenters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BasePresenter<T> : ViewModel()  {

    protected var mView: T? = null
    lateinit var mErrorLD: MutableLiveData<String>

    open fun initPresenter(view: T) {
        this.mView = view
        mErrorLD = MutableLiveData()
    }

    abstract fun onStart()
    abstract fun onStop()

}
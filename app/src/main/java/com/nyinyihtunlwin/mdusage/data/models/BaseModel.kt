package com.nyinyihtunlwin.mdusage.data.models

import com.google.gson.Gson
import com.nyinyihtunlwin.mdusage.network.ApiService
import com.nyinyihtunlwin.mdusage.persistence.MDUDatabase
import com.nyinyihtunlwin.mdusage.utils.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseModel{
    companion object {
        lateinit var mApi : ApiService
        lateinit var mDatabase : MDUDatabase
    }



    init {
        val okHttpClient = OkHttpClient().newBuilder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        mApi = retrofit.create(ApiService::class.java)
    }
}
package com.nyinyihtunlwin.mdusage.network

import com.nyinyihtunlwin.mdusage.network.responses.MDUResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/action/datastore_search")
    fun getMobileDataUsage(@Query("resource_id") resourceId: String): Observable<MDUResponse>
}
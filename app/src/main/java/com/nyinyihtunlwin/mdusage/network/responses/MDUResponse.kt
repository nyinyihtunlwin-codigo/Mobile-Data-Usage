package com.nyinyihtunlwin.mdusage.network.responses

import com.google.gson.annotations.SerializedName
import com.nyinyihtunlwin.mdusage.data.vos.ResultVO

class MDUResponse(
    @SerializedName("help")
    val help: String? = null,
    @SerializedName("success")
    val isSuccess: Boolean = false,
    @SerializedName("result")
    val result: ResultVO? = null
)

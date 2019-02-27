package com.nyinyihtunlwin.mdusage.data.vos

import com.google.gson.annotations.SerializedName

data class RecordVO(
    @SerializedName("volume_of_mobile_data")
    val volOfMobileData: String? = null,
    @SerializedName("quarter")
    val quarter: String? = null,
    @SerializedName("_id")
    val id: Int = 0
)
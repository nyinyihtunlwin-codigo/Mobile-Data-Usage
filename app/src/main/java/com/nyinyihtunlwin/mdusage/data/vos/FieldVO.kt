package com.nyinyihtunlwin.mdusage.data.vos

import com.google.gson.annotations.SerializedName

data class FieldVO(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("id")
    val id: String? = null
)
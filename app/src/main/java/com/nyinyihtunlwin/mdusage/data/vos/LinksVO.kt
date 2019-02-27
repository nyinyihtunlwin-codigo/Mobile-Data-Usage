package com.nyinyihtunlwin.mdusage.data.vos

import com.google.gson.annotations.SerializedName

data class LinksVO(
    @SerializedName("start")
    val start: String? = null,
    @SerializedName("next")
    val next: String? = null
)
package com.nyinyihtunlwin.mdusage.data.vos

import com.google.gson.annotations.SerializedName

data class ResultVO(
    @SerializedName("resource_id")
    val resourceId: String? = null,
    @SerializedName("fields")
    val fields: List<FieldVO>? = null,
    @SerializedName("records")
    val records: List<RecordVO>? = null,
    @SerializedName("_links")
    val links: LinksVO? = null,
    @SerializedName("total")
    val total: Int = 0
)
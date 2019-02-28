package com.nyinyihtunlwin.mdusage.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.nyinyihtunlwin.mdusage.utils.AppConstants

@Entity(tableName = AppConstants.TABLE_RECORDS)
data class RecordVO(
    @PrimaryKey
    @SerializedName("_id")
    val id: Int = 0,
    @SerializedName("volume_of_mobile_data")
    val volOfMobileData: String? = null,
    @SerializedName("quarter")
    val quarter: String? = null

)
package com.nyinyihtunlwin.mdusage.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nyinyihtunlwin.mdusage.data.vos.RecordVO
import com.nyinyihtunlwin.mdusage.utils.AppConstants

@Dao
abstract interface MDUDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRecord(record: RecordVO): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRecords(records: List<RecordVO>): LongArray

    @Query("SELECT * FROM ${AppConstants.TABLE_RECORDS}")
    abstract fun getRecords(): List<RecordVO>

    @Query("SELECT * FROM ${AppConstants.TABLE_RECORDS} WHERE id = :id")
    abstract fun getRecordById(id: String): RecordVO?

    @Query("DELETE FROM ${AppConstants.TABLE_RECORDS} WHERE id = :id")
    abstract fun deleteRecordById(id: String): Int

}
package com.nyinyihtunlwin.mdusage.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nyinyihtunlwin.mdusage.data.vos.RecordVO
import com.nyinyihtunlwin.mdusage.persistence.dao.MDUDao

@Database(
    entities = [RecordVO::class], version = 1, exportSchema = false
)
abstract class MDUDatabase:RoomDatabase() {

    abstract fun mduDao(): MDUDao

    companion object {

        private const val DB_NAME = "MobileDataUsage.db"
        private var INSTANCE: MDUDatabase? = null

        fun getDatabase(context: Context): MDUDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MDUDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                    .build()
            }
            return INSTANCE!!
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}
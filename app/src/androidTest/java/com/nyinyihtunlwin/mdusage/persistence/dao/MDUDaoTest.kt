package com.nyinyihtunlwin.mdusage.persistence.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.nyinyihtunlwin.mdusage.persistence.MDUDatabase
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MDUDaoTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var mDatabase: MDUDatabase? = null

    private var mduDao: MDUDao? = null

    @Before
    @Throws(Exception::class)
    fun initDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            MDUDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        mduDao = mDatabase!!.mduDao()
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        mDatabase!!.close()
    }

    @Test
    @Throws(InterruptedException::class)
    fun onFetchingDataUsage_shouldGetEmptyList_IfTable_IsEmpty() {
        val noteList = mDatabase!!.mduDao().getRecords()
        assertTrue(noteList.isEmpty())
    }
}
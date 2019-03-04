package com.nyinyihtunlwin.mdusage.mvp.presenters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nyinyihtunlwin.mdusage.data.models.MDUModel
import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO
import com.nyinyihtunlwin.mdusage.network.ApiService
import com.nyinyihtunlwin.mdusage.network.responses.MDUResponse
import io.reactivex.Maybe
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MDUPresenterTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    lateinit var mModel: MDUModel

    lateinit  var mResponseLD: MutableLiveData<List<YearDUsageVO>>
    lateinit var mErrorLD: MutableLiveData<String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mModel = MDUModel.getInstance()
        mResponseLD = MutableLiveData()
        mErrorLD = MutableLiveData()
    }

    @Test
    fun fetchDataUsages_nullResponse() {
        Mockito.`when`(this.apiService.getMobileDataUsage(ArgumentMatchers.anyString())).thenAnswer {
            return@thenAnswer Maybe.just(MDUResponse())
        }

        val observer = Mockito.mock(Observer::class.java) as Observer<List<YearDUsageVO>>
        this.mResponseLD.observeForever(observer)

        this.mModel.startLoadingDataUsage(ArgumentMatchers.anyString(),mResponseLD,mErrorLD)

        Assert.assertNull(this.mResponseLD.value)
    }
}
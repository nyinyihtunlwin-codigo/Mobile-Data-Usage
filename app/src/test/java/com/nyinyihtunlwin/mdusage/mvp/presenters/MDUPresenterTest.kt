package com.nyinyihtunlwin.mdusage.mvp.presenters

import androidx.lifecycle.Observer
import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO
import com.nyinyihtunlwin.mdusage.network.ApiService
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MDUPresenterTest{

    @Mock
    lateinit var mduApi: ApiService

    @Mock
    lateinit var observer: Observer<List<YearDUsageVO>>

    lateinit var mPresenter: MDUPresenter

    @Before
    fun setUp() {
    }

}
package com.nyinyihtunlwin.mdusage.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.nyinyihtunlwin.mdusage.R
import com.nyinyihtunlwin.mdusage.mvp.presenters.MDUPresenter
import com.nyinyihtunlwin.mdusage.mvp.views.MDUView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MDUView{

    private lateinit var mPresenter: MDUPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPresenter = ViewModelProviders.of(this@MainActivity).get(MDUPresenter::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onGetDataUsage("a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

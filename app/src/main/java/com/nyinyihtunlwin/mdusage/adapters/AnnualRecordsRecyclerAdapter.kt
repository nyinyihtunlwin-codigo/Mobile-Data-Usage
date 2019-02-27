package com.nyinyihtunlwin.mdusage.adapters

import android.content.Context
import android.view.ViewGroup
import com.nyinyihtunlwin.mdusage.R
import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO
import com.nyinyihtunlwin.mdusage.viewholders.BaseViewHolder
import com.nyinyihtunlwin.mdusage.viewholders.AnnualRecordsViewHolder

class AnnualRecordsRecyclerAdapter(context: Context) : BaseRecyclerAdapter<AnnualRecordsViewHolder, YearDUsageVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<YearDUsageVO> {
        val view = mLayoutInflator.inflate(R.layout.view_item_usage,parent,false)
        return AnnualRecordsViewHolder(view)
    }
}
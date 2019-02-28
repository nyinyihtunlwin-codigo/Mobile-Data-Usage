package com.nyinyihtunlwin.mdusage.viewholders

import android.util.Log
import android.view.View
import android.widget.TextView
import com.nyinyihtunlwin.mdusage.R
import com.nyinyihtunlwin.mdusage.data.vos.YearDUsageVO
import com.nyinyihtunlwin.mdusage.utils.AppConstants
import kotlinx.android.synthetic.main.view_item_usage.view.*
import java.math.RoundingMode
import java.text.DecimalFormat

class AnnualRecordsViewHolder(itemView: View) : BaseViewHolder<YearDUsageVO>(itemView) {
    override fun setData(data: YearDUsageVO) {
        var totalVolumeOfData: Double = 0.0
        var usageQ1: Double? = null
        var usageQ2: Double? = null
        var usageQ3: Double? = null
        var usageQ4: Double? = null

        val df = DecimalFormat("##.#######")
        df.roundingMode = RoundingMode.CEILING


        itemView.ivOverallCondition.visibility = View.GONE
        itemView.tvYear.text = "Year    :   ${data.year.toString()}"

        if (data.q1 != null) {
            usageQ1 = data.q1!!.usage
            totalVolumeOfData += usageQ1
            itemView.tvQ1.text = usageQ1.toString()
            if (AppConstants.tmpMap[data.year!! - 1] != null) {
                if(AppConstants.tmpMap[data.year!! - 1]!! > usageQ1){
                    setDownIcon(itemView.tvQ1)
                }else{
                    setUpIcon(itemView.tvQ1)
                }
            } else {
                setUpIcon(itemView.tvQ1)
            }
            AppConstants.lastDataValue = usageQ1
        } else {
            itemView.tvQ1.text = "-"
            removeIcon(itemView.tvQ1)
        }
        if (data.q2 != null) {
            usageQ2 = data.q2!!.usage
            totalVolumeOfData += usageQ2
            itemView.tvQ2.text = usageQ2.toString()
            if (usageQ1 != null) {
                if (usageQ1 > usageQ2) {
                    setDownIcon(itemView.tvQ2)
                } else {
                    setUpIcon(itemView.tvQ2)
                }
            } else {
                if (AppConstants.lastDataValue > usageQ2) {
                    setDownIcon(itemView.tvQ2)
                } else {
                    setUpIcon(itemView.tvQ2)
                }
            }
            AppConstants.lastDataValue = usageQ2
        } else {
            itemView.tvQ2.text = "-"
            removeIcon(itemView.tvQ2)
        }
        if (data.q3 != null) {
            usageQ3 = data.q3!!.usage
            totalVolumeOfData += usageQ3
            itemView.tvQ3.text = usageQ3.toString()
            if (usageQ2 != null) {
                if (usageQ2 > usageQ3) {
                    setDownIcon(itemView.tvQ3)
                } else {
                    setUpIcon(itemView.tvQ3)
                }
            } else if (usageQ1 != null) {
                if (usageQ1 > usageQ3) {
                    setDownIcon(itemView.tvQ3)
                } else {
                    setUpIcon(itemView.tvQ3)
                }
            } else {
                if (AppConstants.lastDataValue > usageQ3) {
                    setDownIcon(itemView.tvQ3)
                } else {
                    setUpIcon(itemView.tvQ3)
                }
            }
            AppConstants.lastDataValue = usageQ3
        } else {
            itemView.tvQ3.text = "-"
            removeIcon(itemView.tvQ3)
        }
        if (data.q4 != null) {
            usageQ4 = data.q4!!.usage
            totalVolumeOfData += usageQ4
            itemView.tvQ4.text = usageQ4.toString()
            if (usageQ3 != null) {
                if (usageQ3 > usageQ4) {
                    setDownIcon(itemView.tvQ4)
                } else {
                    setUpIcon(itemView.tvQ4)
                }
            } else if (usageQ2 != null) {
                if (usageQ2 > usageQ4) {
                    setDownIcon(itemView.tvQ4)
                } else {
                    setUpIcon(itemView.tvQ4)
                }
            } else if (usageQ1 != null) {
                if (usageQ1 > usageQ4) {
                    setDownIcon(itemView.tvQ4)
                } else {
                    setUpIcon(itemView.tvQ4)
                }
            } else {
                if (AppConstants.lastDataValue > usageQ4) {
                    setDownIcon(itemView.tvQ4)
                } else {
                    setUpIcon(itemView.tvQ4)
                }
            }
            AppConstants.lastDataValue = usageQ4
        } else {
            itemView.tvQ4.text = "-"
            removeIcon(itemView.tvQ4)
        }
        itemView.tvTotalData.text = df.format(totalVolumeOfData).toString()
        itemView.ivOverallCondition.setOnClickListener {
            //
        }
        AppConstants.tmpMap[data.year!!] = AppConstants.lastDataValue
    }

    private fun setUpIcon(tv: TextView) {
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_upward_24dp, 0)
    }

    private fun setDownIcon(tv: TextView) {
        itemView.ivOverallCondition.visibility = View.VISIBLE
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_downward_24dp, 0)
    }

    private fun removeIcon(tv: TextView) {
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
    }

    override fun onClick(v: View?) {
    }


}
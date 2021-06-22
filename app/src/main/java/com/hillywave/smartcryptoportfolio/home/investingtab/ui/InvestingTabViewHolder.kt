package com.hillywave.smartcryptoportfolio.home.investingtab.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hillywave.smartcryptoportfolio.databinding.LayoutInvestingTabBinding
import com.hillywave.smartcryptoportfolio.databinding.ViewInvestingTabItemBinding

class InvestingTabViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

	private val binding = ViewInvestingTabItemBinding.bind(view)

	fun bind(text: String) {
		binding.tvTitle.text = text
	}

}
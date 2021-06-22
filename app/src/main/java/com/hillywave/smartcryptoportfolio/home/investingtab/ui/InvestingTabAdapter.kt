package com.hillywave.smartcryptoportfolio.home.investingtab.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hillywave.smartcryptoportfolio.R
import com.hillywave.smartcryptoportfolio.base.ui.DefaultDiffCallback

class InvestingTabAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	companion object {
		private const val PORTFOLIO_BLOCK_TYPE = 1
		private const val PENDING_BLOCK_TYPE = 2
	}

	private val items = mutableListOf<Any>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return when (viewType) {
			PORTFOLIO_BLOCK_TYPE -> InvestingTabViewHolder(
				LayoutInflater.from(parent.context).inflate(R.layout.view_investing_tab_item, parent, false)
			)
			PENDING_BLOCK_TYPE -> InvestingTabViewHolder(
				LayoutInflater.from(parent.context).inflate(R.layout.view_investing_tab_item, parent, false)
			)
			else -> InvestingTabViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_investing_tab_item, parent, false))
		}
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (holder) {
			is InvestingTabViewHolder -> holder.bind(
				items[position] as String
			)
		}
	}

	override fun getItemCount() = items.size

	override fun getItemViewType(position: Int) = when(items[position]){
		is String -> PORTFOLIO_BLOCK_TYPE
		else -> PENDING_BLOCK_TYPE
	}

	fun updateItems(newList: List<Any>) {
		val diffResult = DiffUtil.calculateDiff(DefaultDiffCallback(newList, items))
		items.clear()
		items.addAll(newList)
		diffResult.dispatchUpdatesTo(this)
	}
}
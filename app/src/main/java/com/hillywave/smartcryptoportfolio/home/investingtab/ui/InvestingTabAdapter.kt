package com.hillywave.smartcryptoportfolio.home.investingtab.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hillywave.smartcryptoportfolio.R
import com.hillywave.smartcryptoportfolio.base.ui.DefaultDiffCallback

class InvestingTabAdapter<T : Any> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val items = mutableListOf<Any>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return InvestingTabViewHolder<T>(LayoutInflater.from(parent.context).inflate(R.layout.view_investing_tab_item, parent, false))
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		(holder as InvestingTabViewHolder<*>).bind(items[position] as String)
	}

	override fun getItemCount() = items.size

	fun updateItems(newList: List<Any>) {
		val diffResult = DiffUtil.calculateDiff(DefaultDiffCallback(newList, items))
		items.clear()
		items.addAll(newList)
		diffResult.dispatchUpdatesTo(this)
	}
}
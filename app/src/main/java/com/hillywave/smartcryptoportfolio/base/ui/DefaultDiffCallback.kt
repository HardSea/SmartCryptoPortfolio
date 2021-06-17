package com.hillywave.smartcryptoportfolio.base.ui

import androidx.recyclerview.widget.DiffUtil

class DefaultDiffCallback(
	private val newList: List<Any>,
	private val oldList: List<Any>
) : DiffUtil.Callback() {

	override fun getOldListSize() = oldList.size

	override fun getNewListSize() = newList.size

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return oldList[oldItemPosition] == newList[newItemPosition]
	}

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return oldList[oldItemPosition] == newList[newItemPosition]
	}
}
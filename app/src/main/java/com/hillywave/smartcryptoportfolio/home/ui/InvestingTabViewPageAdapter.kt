package com.hillywave.smartcryptoportfolio.home.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hillywave.smartcryptoportfolio.home.investingtab.domain.InvestingTabCategory
import com.hillywave.smartcryptoportfolio.home.investingtab.ui.InvestingTabFragment

class InvestingTabViewPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

	companion object {
		private const val INVESTING_TAB_PORTFOLIO = 0
		private const val INVESTING_TAB_PENDING = 1
	}

	override fun getItemCount(): Int = 2

	override fun createFragment(position: Int): Fragment = when (position) {
		INVESTING_TAB_PORTFOLIO -> {
			InvestingTabFragment<InvestingTabCategory.Portfolio>()
		}
		else -> {
			InvestingTabFragment<InvestingTabCategory.Pending>()
		}
	}
}
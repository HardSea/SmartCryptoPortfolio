package com.hillywave.smartcryptoportfolio.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.hillywave.smartcryptoportfolio.R
import com.hillywave.smartcryptoportfolio.base.ui.BaseFragment
import com.hillywave.smartcryptoportfolio.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment(R.layout.home_fragment) {

	private lateinit var bindings: HomeFragmentBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		bindings = HomeFragmentBinding.inflate(layoutInflater)
		initInvestingTab()
		return bindings.root
	}

	private fun initInvestingTab() {
		bindings.investmentsViewPager.isUserInputEnabled = false
		val selectedTextColor = ContextCompat.getColor(requireActivity(), R.color.white)
		val unselectedTextColor = ContextCompat.getColor(requireActivity(), R.color.gray_text_color)
		bindings.layoutInvestingTab.apply {
			tabInvestingTab1.setOnClickListener {
				switchInvestingTab(size = 0f, tab1Color = selectedTextColor, tab2Color = unselectedTextColor, currentItem = 0)
			}
			tabInvestingTab2.setOnClickListener {
				switchInvestingTab(
					size = tabInvestingTab2.width.toFloat(),
					tab1Color = unselectedTextColor,
					tab2Color = selectedTextColor,
					currentItem = 1
				)
			}
		}
		bindings.investmentsViewPager.adapter = InvestingTabViewPageAdapter(this)
	}

	private fun switchInvestingTab(tab1Color: Int, tab2Color: Int, size: Float, currentItem: Int) {
		bindings.layoutInvestingTab.apply {
			tabInvestingSelectedTab.animate().x(size).duration = 100
			tabInvestingTab1.setTextColor(tab1Color)
			tabInvestingTab2.setTextColor(tab2Color)
			bindings.investmentsViewPager.currentItem = currentItem
		}
	}

	companion object {
		fun newInstance(): HomeFragment {
			return HomeFragment()
		}
	}
}
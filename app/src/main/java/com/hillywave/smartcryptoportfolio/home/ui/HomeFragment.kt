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
				tabInvestingSelectedTab.animate().x(0f).duration = 100
				tabInvestingTab1.setTextColor(selectedTextColor)
				tabInvestingTab2.setTextColor(unselectedTextColor)
				bindings.investmentsViewPager.currentItem = 0
			}
			tabInvestingTab2.setOnClickListener {
				tabInvestingTab1.setTextColor(unselectedTextColor)
				tabInvestingTab2.setTextColor(selectedTextColor)
				val size: Float = tabInvestingTab2.width.toFloat()
				tabInvestingSelectedTab.animate().x(size).duration = 100
				bindings.investmentsViewPager.currentItem = 1
			}
		}
		bindings.investmentsViewPager.adapter = InvestingViewPagerAdapter(this)
	}

	companion object {
		fun newInstance(): HomeFragment {
			return HomeFragment()
		}
	}
}
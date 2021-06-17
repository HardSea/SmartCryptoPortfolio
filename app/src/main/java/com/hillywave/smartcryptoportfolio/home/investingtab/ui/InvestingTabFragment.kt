package com.hillywave.smartcryptoportfolio.home.investingtab.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hillywave.smartcryptoportfolio.R
import com.hillywave.smartcryptoportfolio.base.ui.BaseFragment
import com.hillywave.smartcryptoportfolio.databinding.FragmentInvestingTabBinding

class InvestingTabFragment<T : Any> : BaseFragment(R.layout.fragment_investing_tab) {

	private lateinit var bindings: FragmentInvestingTabBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		bindings = FragmentInvestingTabBinding.inflate(layoutInflater)
		initRecyclerView()
		return bindings.root
	}

	private fun initRecyclerView() {
		bindings.rvTabItems.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

	}

	companion object {
		//fun newInstance() = InvestingTabFragment()
	}
}
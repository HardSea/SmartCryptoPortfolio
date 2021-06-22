package com.hillywave.smartcryptoportfolio.home.investingtab.domain

sealed class InvestingTabCategory() {
	class Pending(val text: String) : InvestingTabCategory()
	class Portfolio() : InvestingTabCategory()
}
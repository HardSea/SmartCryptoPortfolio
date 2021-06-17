package com.hillywave.smartcryptoportfolio.home.investingtab.domain

sealed class InvestingTabCategory() {
	class Pending() : InvestingTabCategory()
	class Portfolio() : InvestingTabCategory()
}
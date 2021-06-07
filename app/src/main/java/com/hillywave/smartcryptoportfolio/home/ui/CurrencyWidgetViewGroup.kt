package com.hillywave.smartcryptoportfolio.home.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.hillywave.smartcryptoportfolio.R
import com.hillywave.smartcryptoportfolio.databinding.CurrencyWidgetViewBinding

enum class ChangeDirection(val value: Int) {
	UP(1),
	DOWN(0);

	companion object {
		fun fromId(id: Int): ChangeDirection {
			for (f in values())
				if (f.value == id) return f
			throw java.lang.IllegalArgumentException()
		}
	}
}

class CurrencyWidgetViewGroup @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null) : ConstraintLayout(context, attributeSet) {

	private var binding: CurrencyWidgetViewBinding =
		CurrencyWidgetViewBinding.inflate(LayoutInflater.from(context), this, true)

	init {
		setupAttributes(attributeSet)
	}

	private fun setupAttributes(attributeSet: AttributeSet?) {
		val typedArray = context.theme.obtainStyledAttributes(
			attributeSet, R.styleable.CurrencyWidgetView,
			0, 0
		)

		val name = typedArray.getString(R.styleable.CurrencyWidgetView_name)
		changeName(name)
		val value = typedArray.getString(R.styleable.CurrencyWidgetView_value)
		changeValue(value)
		val price = typedArray.getString(R.styleable.CurrencyWidgetView_price)
		changePrice(price)
		val changePercent = typedArray.getString(R.styleable.CurrencyWidgetView_changePercent)
		changePercent(changePercent)

		if (name.isNullOrEmpty() || value.isNullOrEmpty() || price.isNullOrEmpty() || changePercent.isNullOrEmpty()) invalidate()

		val changeDirection = ChangeDirection.fromId(typedArray.getInt(R.styleable.CurrencyWidgetView_changeDirection, 0))
		typedArray.recycle()

		changeDirection(changeDirection)
	}

	fun changeName(name: String?) {
		binding.tvCurrencyTitle.text = name
	}

	fun changeValue(value: String?) {
		binding.tvAvailableValue.text = value
	}

	fun changePrice(price: String?) {
		binding.tvCurrencyPrice.text = price
	}

	fun changePercent(changePercent: String?) {
		binding.tvChangePercent.text = changePercent
	}

	fun changeDirection(changeDirection: ChangeDirection) {
		binding.apply {
			when (changeDirection) {
				ChangeDirection.DOWN -> {
					tvChangePercent.setTextColor(ContextCompat.getColor(context, R.color.red))
					tvChangePercent.text = context.getString(R.string.down_change_percent_text, tvChangePercent.text)
				}
				ChangeDirection.UP -> {
					tvChangePercent.setTextColor(ContextCompat.getColor(context, R.color.green))
					tvChangePercent.text = context.getString(R.string.up_change_percent_text, tvChangePercent.text)
				}
			}
		}
	}
}
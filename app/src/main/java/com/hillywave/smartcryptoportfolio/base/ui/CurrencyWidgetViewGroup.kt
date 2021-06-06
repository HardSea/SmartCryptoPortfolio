package com.hillywave.smartcryptoportfolio.base.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.hillywave.smartcryptoportfolio.R
import com.hillywave.smartcryptoportfolio.databinding.CurrencyWidgetViewBinding

private enum class ChangeDirection(val value: Int) {
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
		//inflate(context, binding.root, this)
		//addView(binding.root)
	}

	private fun setupAttributes(attributeSet: AttributeSet?) {
		val typedArray = context.theme.obtainStyledAttributes(
			attributeSet, R.styleable.CurrencyWidgetView,
			0, 0
		)

		val name = typedArray.getString(R.styleable.CurrencyWidgetView_name)
		val value = typedArray.getString(R.styleable.CurrencyWidgetView_value)
		val price = typedArray.getString(R.styleable.CurrencyWidgetView_price)
		val changePercent = typedArray.getString(R.styleable.CurrencyWidgetView_changePercent)

		if (name.isNullOrEmpty() || value.isNullOrEmpty() || price.isNullOrEmpty() || changePercent.isNullOrEmpty()) invalidate()

		val changeDirection = ChangeDirection.fromId(typedArray.getInt(R.styleable.CurrencyWidgetView_changeDirection, 0))
		typedArray.recycle()

		binding.apply {
			tvCurrencyTitle.text = name
			tvAvailableValue.text = value
			tvCurrencyPrice.text = price
			tvChangePercent.text = changePercent
		}
		setPriceDirection(changeDirection)
	}

	private fun setPriceDirection(changeDirection: ChangeDirection) {
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
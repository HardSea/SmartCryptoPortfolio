package com.hillywave.smartcryptoportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hillywave.smartcryptoportfolio.home.ui.HomeFragment

class MainActivity : AppCompatActivity() {

	private val tabIcons = listOf(
		R.drawable.ic_list,
		R.drawable.ic_star,
		R.drawable.ic_settings,
		R.drawable.ic_people
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		supportFragmentManager
			.beginTransaction()
			.replace(R.id.container, HomeFragment.newInstance())
			.commit()

	}
}
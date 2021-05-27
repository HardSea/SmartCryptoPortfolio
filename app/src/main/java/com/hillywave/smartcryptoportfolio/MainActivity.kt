package com.hillywave.smartcryptoportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hillywave.smartcryptoportfolio.home.ui.HomeFragment

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		supportFragmentManager
			.beginTransaction()
			.replace(R.id.container, HomeFragment.newInstance())
			.commit()
	}
}
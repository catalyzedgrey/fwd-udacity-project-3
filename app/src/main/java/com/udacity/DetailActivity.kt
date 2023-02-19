package com.udacity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.delay

class DetailActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        textView = this.findViewById(R.id.status_text)
        backButton = this.findViewById(R.id.animated_back_button)

        textView.text = intent.getStringExtra(this.getString(R.string.status))

        backButton.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                this.finish()
            }, 2000)
        }
    }
}

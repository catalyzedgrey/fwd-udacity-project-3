package com.udacity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var statusTextView: TextView
    lateinit var fileNameTextView: TextView
    lateinit var backButton: Button
    lateinit var motionLayout: MotionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        motionLayout = this.findViewById(R.id.motion_layout)
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.end) {
                    this@DetailActivity.finish()
                }
            }

            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
            }


            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }
        }
        )


        backButton = this.findViewById(R.id.animated_back_button)

        statusTextView = this.findViewById(R.id.status_text)
        statusTextView.text = intent.getStringExtra(this.getString(R.string.status))

        fileNameTextView = this.findViewById(R.id.file_name_text)
        val x  = intent.getStringExtra(this.getString(R.string.filename))
        fileNameTextView.text = x
    }
}

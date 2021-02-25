package kz.step.cw4

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var callButton: Button? = null
    var cameraButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        callButton = findViewById(R.id.button_main_activity_call)
        cameraButton = findViewById(R.id.button_main_activity_camera)
    }

    private fun initializeLiseners() {
        callButton?.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        cameraButton?.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_CAMERA_BUTTON
            intent.putExtra(
                Intent.EXTRA_KEY_EVENT, KeyEvent(
                    KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_CAMERA
                )
            )
            sendOrderedBroadcast(intent, null)
        }
    }



}
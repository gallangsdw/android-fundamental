package com.example.mybackgroundthread

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception
import java.lang.ref.WeakReference
import javax.sql.ConnectionEventListener

class MainActivity : AppCompatActivity(){

    companion object {
        private const val INPUT_STRING = "Halo Ini Demo AsyncTask!!"
        private const val LOG_ASYNC = "DemoAsync"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_status.setText(R.string.status_pre)
        tv_desc.text = INPUT_STRING

        GlobalScope.launch(Dispatchers.IO) {
            val input = INPUT_STRING
            var output: String? = null

            Log.d(LOG_ASYNC, "status : doInBackground")
            try {
                output = "$input Selamat belajar!"

                delay(3000)

                withContext(Dispatchers.Main) {
                    tv_status.setText(R.string.status_post)
                    tv_desc.text = output
                }
            } catch (e: Exception) {
                Log.d(LOG_ASYNC, e.message.toString())
            }
        }
    }
}
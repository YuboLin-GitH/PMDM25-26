package com.example.ejemploframelayout

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemploframelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  mibinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mibinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mibinding.root)

        cambiarC()


    }

    private fun cambiarC() {


        mibinding.analogClock.setOnClickListener {
            mibinding.checkBox.visibility = View.VISIBLE
            mibinding.analogClock.visibility = View.INVISIBLE

        }

        mibinding.checkBox.setOnClickListener {
            mibinding.textView.visibility = View.VISIBLE
            mibinding.checkBox.visibility = View.INVISIBLE
        }

        mibinding.textView.setOnClickListener {
            mibinding.textView.visibility = View.INVISIBLE
            mibinding.button.visibility = View.VISIBLE
        }

        mibinding.button.setOnClickListener {
            mibinding.button.visibility = View.INVISIBLE
            mibinding.analogClock.visibility = View.VISIBLE
        }

    }
}
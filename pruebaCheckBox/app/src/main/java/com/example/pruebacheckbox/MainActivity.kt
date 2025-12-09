package com.example.pruebacheckbox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var button = findViewById<Button>(R.id.button)
        var checkBox1 = findViewById<CheckBox>(R.id.checkBox)
        var checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        var checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        var textView = findViewById<TextView>(R.id.textView)


        button.setOnClickListener {
/*
            if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked){
                textView.text = ("${checkBox1.text} , ${checkBox2.text}, ${checkBox3.text}")
            }
            else if (checkBox1.isChecked && checkBox2.isChecked){
                textView.text = ("${checkBox1.text} , ${checkBox2.text}")
            }
            else if (checkBox2.isChecked && checkBox3.isChecked){
                textView.text = ("${checkBox2.text} , ${checkBox3.text}")
            }
            else if (checkBox1.isChecked && checkBox3.isChecked){
                textView.text = ("${checkBox1.text} , ${checkBox3.text}")
            }
*/
            textView.setText("")

            if(checkBox1.isChecked){
                textView.setText(
                    "${textView.text} ${checkBox1.text}"
                )
            }
           if(checkBox2.isChecked){
               textView.setText(
                   "${textView.text}  ${checkBox2.text}"
               )
            }
            if(checkBox3.isChecked){
                textView.setText(
                    "${textView.text}  ${checkBox3.text}"
                )

            }

        }
    }
}
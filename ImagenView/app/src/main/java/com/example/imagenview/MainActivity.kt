package com.example.imagenview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

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
        //Instanciar el objeto ImagenView
        val i = findViewById<ImageView>(R.id.imageView)
        i.setImageResource(R.drawable.stitch_png_bebe)
        i.contentDescription= resources.getString(R.string.app_name)
        i.adjustViewBounds=true
        i.layoutParams= ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        var mieditText = findViewById<EditText>(R.id.editTextPhone)

        var miobjetoWatcher = object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                TODO("Not yet implemented")
            }

        }
        mieditText.addTextChangedListener(miobjetoWatcher)

        mieditText.addTextChangedListener {  }

        mieditText.setOnClickListener {

        }



    }
}
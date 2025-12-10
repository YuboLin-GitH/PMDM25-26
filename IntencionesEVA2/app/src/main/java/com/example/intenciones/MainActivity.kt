package com.example.intenciones


import android.content.Intent

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
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
        var btweb = findViewById<Button>(R.id.btWeb)

        var btCompartir = findViewById<Button>(R.id.btCompartir)

        var btLlamar = findViewById<Button>(R.id.btLlamar)

        btweb.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/")
            )
            startActivity(intent)
        }

        btCompartir.setOnClickListener {
            val textIntent = Intent(Intent.ACTION_SEND)
            textIntent.setType("text/plain")
            val shareText = "Hola, soy Yubo. Solo quería saludarte."
            textIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(textIntent)
        }


        // ejercicio 8
        /* error  por permison
        btLlamar.setOnClickListener {
            val telefonoNumber = "tel:962849347"
            val llamarIntent = Intent(Intent.ACTION_CALL, Uri.parse(telefonoNumber))
            startActivity(llamarIntent)
        }
        */

        //ejecicio 9

        btLlamar.setOnClickListener {

            val dialIntent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:983454554")
            )
            startActivity(dialIntent)

        }

        // ejercicio 10


        //Foto
        var btFoto = findViewById<Button>(R.id.btFoto)

        btFoto.setOnClickListener {

            val fotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivity(fotoIntent)
        }

        //Mapa

        var btMapa = findViewById<Button>(R.id.btMapa)

        btMapa.setOnClickListener {
            val mapaIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.995656,-0.166093?z=18"))
            startActivity(mapaIntent)
        }

        //Correo

        var btCorreo = findViewById<Button>(R.id.btCorreo)

        btCorreo.setOnClickListener {
            val correoIntent = Intent(Intent.ACTION_SEND)
            correoIntent.setType("text/plain")

            correoIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("jtomas@upv.es"))

            correoIntent.putExtra(Intent.EXTRA_SUBJECT, "asunto")

            correoIntent.putExtra(Intent.EXTRA_TEXT, "Texto del correo.")

            startActivity(correoIntent)
        }


        //  Google Street View

        var btStreetView = findViewById<Button>(R.id.btStreetView)

        btStreetView.setOnClickListener {

            val streetViewIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("google.streetview:cbll=38.996766,-0.1652696&cbp=0,250,0,0,0"))
            startActivity(streetViewIntent)
        }


    }
}
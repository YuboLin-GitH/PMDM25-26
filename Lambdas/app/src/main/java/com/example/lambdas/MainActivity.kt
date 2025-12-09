package com.example.lambdas

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    fun calcularsumacadena (cad:String):Int{


    }

    fun String.caclularsumacadea2():Int{

    }

    //funcion como exprfesion lambda que sune dos numeor enteros
    //esa funcion se la voy a asiognar a una variable
    var mifuncionsuma:(Int,Int)->Unit={a:Int,b:Int-> Toast.makeText(this,"$a+$b=${a+b}", Toast.LENGTH_LONG).show()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var cadena="Hola 7 adios 9"

        println(calcularsumacadena(cadena))

        println(cadena.caclularsumacadea2())
        //obtengo la referencia del textview
        var mitext=findViewById<TextView>(R.id.mitextview)

        mitext.setOnClickListener {
            mifuncionsuma(4,3)
        }

        /*
       //referenciar un objeto de mi clase Milistener
        var milistener = Milistener()
        //vinculo el evento Click del textview al Listener
        mitext.setOnClickListener(milistener)

        //otra formna con lambda mas reducido
       /* mitext.setOnClickListener (View.OnClickListener()){
            override fun onClick(v: View?) {
                //Convierto el view a textview
                var mitextview=v as TextView

                //Cambio el texto del textview
                mitextview.text="Hola Mundo"
                Log.i("Mensaje","el id del textview es: ${mitextview.id}")
            }
        }*/*/
        /*

        //CON LAMBDA
        mitext.setOnClickListener {
            //v:View->
            //var mitextview=v as TextView
            var mitextview=it as TextView

            //Cambio el texto del textview
            mitextview.text="Hola Mundo"
            Log.i("Mensaje","el id del textview es: ${mitextview.id}")
        }
    }*/

}}
/*
class Milistener: View.OnClickListener{
    override fun onClick(v: View?) {
        //Convierto el view a textview
        var mitextview=v as TextView

        //Cambio el texto del textview
        mitextview.text="Hola Mundo"
        Log.i("Mensaje","el id del textview es: ${mitextview.id}")
    }
}*/
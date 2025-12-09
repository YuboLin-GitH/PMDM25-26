package com.example.pruebakotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pruebakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  mibinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        mibinding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()


        mibinding.button.setOnClickListener {
            if (anagrama(mibinding.cadEditText1.text.toString(), mibinding.cadEditText2.text.toString())){
                mibinding.resultadoTextView.text = "✅ Son anagramas"
            }else{
                mibinding.resultadoTextView.text = "❌ No son anagramas"
            }
        }


        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }


    private fun anagrama(cad1:String, cad2:String): Boolean{


       // var cadena2: String = mibinding.cadEditText2.toString()
        var i = 0

        var cadema_resultado = cad2
        //Declaro otra variable que se digo si las cadenas son anagrama 0 no
        var es_anagrama= true

        while(es_anagrama && i< cad1.length)
        {
            //Comprobar si el caracter de la posicion de cad1 esta en cadena:resultado
            if (cadema_resultado.contains(cad1.get(i)))
            {
                cadema_resultado = cadema_resultado.replaceFirst(cad1.get(i).toString(), "", true)
            }
            else
            {
                es_anagrama= false
            }

            i++
        }
            return es_anagrama && cadema_resultado.isEmpty()
    }



}




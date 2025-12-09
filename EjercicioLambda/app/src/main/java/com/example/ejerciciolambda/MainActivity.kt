package com.example.ejerciciolambda

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerciciolambda.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mibinding : ActivityMainBinding;
    var miArray= Array<Int>(10,{
        Log.i("MENSAJE","Generando numeros")
        Random.nextInt(1,100) })
    //Creo el array resultado
    lateinit var miArray_resultado: Array<Int>


    // Variable que contiene la funcion para saber si un numero es primo
    val es_primo:(Int)-> Boolean={ num:Int ->
        var primo =true
        var divisor = 2;
        // Recorremos todos los valors entre 2 y num/2
        while (primo && divisor<(num/2)){
            primo= (num%divisor!=0)
            // pasemos al siguiente valor de divisor
            divisor++
        }
        // Retornamos el valor de la variable primo, no pone el return
        primo

    }

    // variable que contenga
    val es_magico:(Int)-> Boolean={ num:Int->
        var magico= true
        var cubo=Math.pow(num.toDouble(), 3.0).toInt()
        var sumdigitos=0
        var digito=0
        var cociente=cubo
        //VOy separando todos los digitos del cubo
        while (cociente != 0)
        {
            //preparo para la siguiente operacion
            digito =cociente%10
            cociente= cociente/10
            sumdigitos+=digito
        }
        magico=(sumdigitos== num )
        magico
    }

    // Variable que almacena una funcion es_capicua
    val es_capicua:(Int)-> Boolean={num:Int->
        var capicua=false
        // Convierto el numero a String y lo do la vuelta
        var numero = num.toString()
        var numero_alreves=numero.reversed()
        capicua= (numero == numero_alreves)
        capicua

    }

    //Defino una funcion de orden superior
    fun filtrar_numeros(lista_numeros: Array<Int>, func:(Int)-> Boolean): Array<Int>
    {
        //Declaro una lista vacia que va a almacenar
        // los valores de lista_numeros que cumplen con
        //el filtro func
        var listaResultado = mutableListOf<Int>()

        //Recorro la lista de numeros, es decir el ler parametro
        //y filtro segun la funcion func los valores que
        //cumplan la condicion definida en esa funcion func
        for (elemento in lista_numeros)
        {
            //Añado a listaresultado si el elemento
            // segun la funcion func es true
            if (func(elemento))
                listaResultado.add(elemento)
        }
        return listaResultado.toTypedArray()


    }



    override fun onCreate(savedInstanceState: Bundle?) {

        mibinding = ActivityMainBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Llamamos a una funcion que inicializa los componentes
        //visuales
        inicializar_componentes()



        }

    private fun inicializar_componentes() {

        mibinding.etiquetaArray.text=miArray.joinToString(", ")
        //Asigno funcionalidad al boton
        mibinding.btFiltra.setOnClickListener {
            when(mibinding.GroupRadioBoton.checkedRadioButtonId){
                R.id.rbPrimos->{
                    Log.i("MENSAJE","Filtro_Primos")
                   this.miArray_resultado = filtrar_numeros(miArray, es_primo)
                }
                R.id.rbMagicos-> {
                    Log.i("MENSAJE","Filtro_Magico")
                    this.miArray_resultado = filtrar_numeros(miArray, es_magico)
                }
                R.id.rbCapicuas->{
                    Log.i("MENSAJE","Filtro_Primos")
                    this.miArray_resultado = filtrar_numeros(miArray, es_capicua)
                }

            }

        mibinding.txtResultado.text=miArray_resultado.joinToString(", ")
        }
    }


    }



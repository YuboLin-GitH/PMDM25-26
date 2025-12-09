package com.example.simulacionexamen_kotlin

class Juego_de_Palabras() {

    private var palabras = mutableListOf<String>("Arrancar","Patata","Juego","Pizarra")

    private  val pista = ArrayList<String>().apply {
        add("Faltan caracteres")
        add("Cambio de vocal")
        add("Posicion del caracter")
        add("Cambia consonante")
    }

    var puntos = 2
        get()=field
        set(value){
            field=value
        }

    var palabraOriginal: String = ""
    var tipoCambio: Int = 0


    constructor(palabras: ArrayList<String>):this() {
        this.palabras = palabras
    }

    fun nuevaRonda() {
        palabraOriginal = palabras.random()
        tipoCambio = (0..3).random()
    }

    fun obtener_Palabra():String {
       return palabras.random()
    }


    fun obtener_Pista(n: Int): String{
        return pista[n]
    }




}
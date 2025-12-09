package com.example.simulacionexamen_kotlin

import kotlin.random.Random


fun String.transformar(descolocada: Boolean, func_cambiar:(c:Char, a: Int)-> Char): String{

    var palabraModificada = ""


    //Conjunto que guarda las posiciones a cambiar

    if (descolocada){
        // Descolocamos la palabra original de forma aleatoria
        var posiciones =mutableSetOf<Int>()

        while (posiciones.size < this.length){
            posiciones.add(Random.nextInt(0, this.length))
        }
        // Descolocamos la palabra
        //Recorro las posiciones de la palabras
        posiciones.forEach { pos ->
            palabraModificada += this[pos]
        }
    }
    else{
        palabraModificada= this
    }
    //Transformar la palabra, se recorre la palabra y se invoca por
    //cada caracter a la func_cambiar
    var palabraFinal=""

    for (i in 0 .. this.length-1)
    {
        palabraFinal += func_cambiar(palabraModificada[i], i)
    }

    // retornar palabrar
    return palabraFinal
}

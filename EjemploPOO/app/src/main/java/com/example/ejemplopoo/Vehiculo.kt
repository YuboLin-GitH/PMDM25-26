package com.example.ejemplopoo

abstract class Vehiculo(var marca:String, var modolo:String, var anio: Int,
         var valocidad_max: Int): Conducible{

    override fun arrancar() = "El vehiculo $marca ha arrancado"

    override fun detener()  = "El vehiculo $marca se ha detenido"

    abstract fun acelerar(): String

}
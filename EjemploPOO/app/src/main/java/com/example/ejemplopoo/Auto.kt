package com.example.ejemplopoo

 class Auto(mar:String, mod:String, an:Int, vel_max: Int,
                    var num_puertas:Int) :
     Vehiculo(mar,mod,an,vel_max) {

    override fun acelerar(): String = "El auto $marca esta acelerando"


 }
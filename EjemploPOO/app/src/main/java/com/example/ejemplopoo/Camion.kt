package com.example.ejemplopoo

class Camion (m:String, mod:String, an:Int, vel_max: Int,
              var capacidadCarga: Double) :
    Vehiculo(m,mod,an,vel_max) {
      //  private var capacidadCarga = 0

    // Constructor secvundario para iniaializar capacidad de carga

    constructor(cap_carga: Double):this("","",0,0,cap_carga){
        capacidadCarga=cap_carga
    }

    override fun acelerar(): String = "El camion $marca esta acelerando " + "con una carga de $capacidadCarga "


}
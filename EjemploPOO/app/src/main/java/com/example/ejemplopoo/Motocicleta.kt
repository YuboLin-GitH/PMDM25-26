package com.example.ejemplopoo

class Motocicleta(m: String, mod: String, an:Int,vel_Max: Int): Vehiculo(m, mod,an,vel_Max) {

    var esDeportiva: Boolean= false
        get() = field
        set(value){
            if(marca in "Suzuki,Honda"){
                field =true
            }
            else
                field= false
        }
    override fun acelerar() = "La motocicleta $marca esta acelerando a toda velocidad"

}
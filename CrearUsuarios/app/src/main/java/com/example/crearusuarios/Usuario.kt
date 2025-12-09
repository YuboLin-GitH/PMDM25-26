package com.example.crearusuarios
enum class TipoUsuario{Normal,Administrador}
data class Usuario(var nombre:String,var edad:Int,var tipo:TipoUsuario)

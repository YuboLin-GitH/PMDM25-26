package com.example.ejercicopoo_finaltema2

import java.sql.Date

open class Usuario constructor(
    login: String,
    password: String,
    fechaNac: Date= Date(0),
    email: String = "email@gmail.com"

)  {
    var login: String = login
        get() = field
        set(value) {
            if(value == "")
                    field = "desconocido"
            else
                field = value
        }
    var password: String=  password
    var fechaNac: Date? = fechaNac
        set(value){
            if(value == ""){
                field = value
            else
                field = null
        }
    var email : String= "1@1.com"


}
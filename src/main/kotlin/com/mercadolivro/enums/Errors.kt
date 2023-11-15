package com.mercadolivro.enums

enum class Errors (
    val code: String, val message: String
){
    //Start books erros
    ML101("ML-101", "Book [%s] not exists"),
    //End books erros

    //Start customers erros
    ML201("ML-201", "Customer [%s] not exists")
    //End customers erros
}
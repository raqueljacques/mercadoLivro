package com.mercadolivro.enums

enum class Errors (
    val code: String, val message: String
){
    //tart generic errors
    ML001("ML-001", "Invalid request"),
    //End generic errors

    //Start books erros
    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot delete book with status [%s]"),
    //End books erros

    //Start customers erros
    ML201("ML-201", "Customer [%s] not exists")
    //End customers erros
}
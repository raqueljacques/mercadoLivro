package com.mercadolivro.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest (
    @field:NotEmpty(message = "Invalid name")
    var name: String,
    @field:Email(message = "Invalid email")
    var email: String
)
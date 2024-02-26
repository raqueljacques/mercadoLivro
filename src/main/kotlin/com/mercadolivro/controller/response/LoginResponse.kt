package com.mercadolivro.controller.response

import org.springframework.security.core.token.Token

data class LoginResponse(
    //TODO: Não pode ser null
    val token: Token?
)
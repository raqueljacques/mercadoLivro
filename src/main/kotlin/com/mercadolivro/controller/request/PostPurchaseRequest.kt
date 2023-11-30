package com.mercadolivro.controller.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class PostPurchaseRequest (

    @field:NotNull
    @field:Positive
    val customerId: Int,

    @field:NotNull
    //TODO Set is a collection that does not allow duplicates
    val bookIds: Set<Int>

)

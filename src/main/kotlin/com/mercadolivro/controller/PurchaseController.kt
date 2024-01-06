package com.mercadolivro.controller

import com.mercadolivro.controller.mapper.PurchaseMapper
import com.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("purchase")
class PurchaseController (
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Validated request: PostPurchaseRequest) {
        //TODO:Não deixar vender livros com status diferente de ativo
        purchaseService.create(purchaseMapper.toPurchaseModel(request))
    }

    //TODO: Criar endpoint para listar as compras de um usuário

    //TODO: Criar endpoint para listar os livros vendidos por um usuário
}
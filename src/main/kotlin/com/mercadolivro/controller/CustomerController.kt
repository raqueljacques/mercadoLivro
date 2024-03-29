package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.extension.toResponse
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*


//Deixando claro para o spring que é uma classe controlador
@RestController
//Definindo um caminho para o controlador
@RequestMapping("customers")
class CustomerController(
    private val customerService: CustomerService
    //val authenticationManager: AuthenticationManager,
    //val tokenService: TokenService
) {
    @GetMapping
    //RequestParam para pegar algum parâmetro da url (criação de um filtro pelo nome)
    fun getAll(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    //Mudando o tipo de status do retorno da requisição
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Validated customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

//    @PostMapping("/login")
//    fun login(@RequestBody data: @Valid LoginRequest): ResponseEntity<*>? {
//        val usernamePassword = UsernamePasswordAuthenticationToken(data.email, data.password)
//        val auth: Authentication? = authenticationManager.authenticate(usernamePassword)
//        val token: Token? = tokenService.allocateToken(auth.toString())
//        return ResponseEntity.ok<Any>(LoginResponse(token))
//    }

    //como receber parâmetro pela url
    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id:Int, @RequestBody @Validated customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }


}
package com.mercadolivro.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

//Informa qual classe vai validar a annotation
@Constraint(validatedBy = [EmailAvailableValidator::class])
//Informa que a annotation vai estar disponível em tempo de execução
@Retention(AnnotationRetention.RUNTIME)
//Informa o target da annotation e vai estar associada a um campo
@Target(AnnotationTarget.FIELD)
annotation class EmailAvailable(
    val message: String = "E-mail already exists",
    //Informa que a annotation vai estar associada a um grupo
    val groups: Array<KClass<*>> = [],
    //Informa que a annotation vai estar associada a um payload
    val payload: Array<KClass<out Payload>> = []
)

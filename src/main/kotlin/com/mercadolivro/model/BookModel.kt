package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import jakarta.persistence.*
import jakarta.persistence.Entity
import java.math.BigDecimal


@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

)
{
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if(field == BookStatus.DELETADO || field == BookStatus.CANCELADO)
                throw Exception("Não é possível alterar um livro com status ${field.toString()}")

            field = value
        }
    constructor(id: Int? = null, name: String, price: BigDecimal, status: BookStatus?, customer: CustomerModel? = null) : this(id, name, price, customer) {
        this.status = status
    }
}
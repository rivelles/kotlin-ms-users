package com.example.kotlinmsusers.models.orders

import com.example.kotlinmsusers.models.payments.Payment
import com.example.kotlinmsusers.models.restaurants.Product
import com.example.kotlinmsusers.models.users.Address
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order (@Id @GeneratedValue val id: Long,
                  @ManyToOne(fetch = FetchType.LAZY)
                  val product: Product,
                  @ManyToOne(fetch = FetchType.LAZY)
                  val address: Address,
                  val discount: Double,
                  val status: OrderStatus,
                  @OneToOne(fetch = FetchType.LAZY)
                  val payment: Payment)
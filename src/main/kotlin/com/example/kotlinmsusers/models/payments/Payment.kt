package com.example.kotlinmsusers.models.payments

import com.example.kotlinmsusers.models.orders.Order
import javax.persistence.*

@Entity
data class Payment(@Id @GeneratedValue val id: Long,
              @OneToOne(fetch = FetchType.EAGER)
              val order: Order,
              val paymentMethod: PaymentMethod,
              val status: PaymentStatus)
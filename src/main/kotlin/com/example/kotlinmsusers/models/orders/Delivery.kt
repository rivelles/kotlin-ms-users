package com.example.kotlinmsusers.models.orders

import com.example.kotlinmsusers.models.users.Address
import com.example.kotlinmsusers.models.users.Deliverer
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Delivery(@Id @GeneratedValue val id: Int,
                    @ManyToOne(fetch = FetchType.LAZY)
                    val from: Address,
                    @ManyToOne(fetch = FetchType.LAZY)
                    val to: Address,
                    @ManyToOne(fetch = FetchType.LAZY)
                    val deliverer: Deliverer,
                    @CreationTimestamp
                    val createdAt: LocalDateTime,
                    val deliveredAt: LocalDateTime,
                    val rating: Short)
package com.example.kotlinmsusers.models.restaurants

import javax.persistence.*

@Entity
data class Product(@Id @GeneratedValue val id: Long,
                    val name: String,
                    val price: Double,
                    @ManyToOne(fetch = FetchType.LAZY)
                    val restaurant: Restaurant)
package com.example.kotlinmsusers.models.restaurants

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Product(@Id @GeneratedValue val id: Long,
                    val name: String,
                    val price: Double,
                    @ManyToOne(fetch = FetchType.LAZY)
                    @JsonIgnore
                    val restaurant: Restaurant)
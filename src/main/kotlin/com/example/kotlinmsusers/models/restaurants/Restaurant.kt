package com.example.kotlinmsusers.models.restaurants

import com.example.kotlinmsusers.models.users.Address
import javax.persistence.*

@Entity
data class Restaurant(@Id @GeneratedValue val id: Long,
                      val name: String,
                      val category: RestaurantCategory,
                      @OneToMany(mappedBy = "restaurant")
                      val products: MutableSet<Product>?,
                      @OneToOne
                      val address: Address)
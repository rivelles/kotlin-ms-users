package com.example.kotlinmsusers.dtos

import com.example.kotlinmsusers.models.restaurants.Product
import com.example.kotlinmsusers.models.restaurants.RestaurantCategory

data class RestaurantResponseDTO(val id: Long,
                                 val name: String,
                                 val category: RestaurantCategory,
                                 val products: Set<Product>?,
                                 val address: AddressResponseDTO)
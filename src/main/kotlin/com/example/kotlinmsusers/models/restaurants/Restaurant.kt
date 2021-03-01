package com.example.kotlinmsusers.models.restaurants

import com.example.kotlinmsusers.dtos.RestaurantResponseDTO
import com.example.kotlinmsusers.models.users.Address
import javax.persistence.*

@Entity
data class Restaurant(@Id @GeneratedValue val id: Long,
                      val name: String,
                      val category: RestaurantCategory,
                      @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
                      val products: MutableSet<Product>?,
                      @OneToOne
                      val address: Address) {
    fun toRestaurantResponseDto() = RestaurantResponseDTO(
            id, name, category, products, address.toAddressResponseDto()
    )
}
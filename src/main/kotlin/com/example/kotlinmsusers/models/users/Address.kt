package com.example.kotlinmsusers.models.users

import com.example.kotlinmsusers.dtos.AddressResponseDTO
import com.example.kotlinmsusers.models.restaurants.Restaurant
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Address(@Id @GeneratedValue val id: Long,
                   val type: AddressType,
                   val area: String,
                   val number: String,
                   @ManyToOne(fetch = FetchType.LAZY)
                   @JsonIgnore
                   val client: Client?,
                   @OneToOne(fetch = FetchType.LAZY)
                   val restaurant: Restaurant?) {
    fun toAddressResponseDto() = AddressResponseDTO(
            type, area, number
    )
}
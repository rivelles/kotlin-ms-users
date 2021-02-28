package com.example.kotlinmsusers.dtos

data class ClientResponseDTO(val id: Long,
                             val name: String,
                             val email: String,
                             val document: String,
                             val addresses: List<AddressResponseDTO>?)
package com.example.kotlinmsusers.dtos

import com.example.kotlinmsusers.models.users.AddressType

data class AddressResponseDTO(val type: AddressType, val area: String, val number: String)
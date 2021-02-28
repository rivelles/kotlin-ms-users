package com.example.kotlinmsusers.models.users

import com.example.kotlinmsusers.dtos.AddressResponseDTO
import com.example.kotlinmsusers.dtos.ClientResponseDTO
import javax.persistence.*

@Entity
class Client(id: Long,
                  name: String,
                  email: String,
                  document: String,
                  password: String,
                  @OneToMany(cascade = [CascadeType.ALL])
                  @JoinColumn(name = "client_id")
                  val addresses: MutableList<Address>): User(id, name, email, document, password) {

    fun toClientResponseDto() = ClientResponseDTO(
            id, name, email, document, addresses.map { it.toAddressResponseDto() }
    )
}
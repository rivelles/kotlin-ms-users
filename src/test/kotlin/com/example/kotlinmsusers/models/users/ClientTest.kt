package com.example.kotlinmsusers.models.users

import com.example.kotlinmsusers.dtos.AddressResponseDTO
import com.example.kotlinmsusers.dtos.ClientResponseDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ClientTest {

    lateinit var client: Client

    @BeforeAll
    fun initialize() {
        client = Client(1,
                "Lucas",
                "rivelleslucas@gmail.com",
                "123456",
                "1234",
                mutableListOf(Address(1, AddressType.STREET, "Manifesto", "198", null, null)))
    }


    @Test
    fun whenClientExists_thenReturnClientResponseDto() {
        val expectedClientDto = ClientResponseDTO(client.id,
                client.name,
                client.email,
                client.document,
                client.addresses.map { it.toAddressResponseDto() })

        val clientResponseDTO = client.toClientResponseDto()

        assertAll(
                Executable { assertEquals(clientResponseDTO.id, expectedClientDto.id) },
                Executable { assertEquals(clientResponseDTO.name, expectedClientDto.name) },
                Executable { assertEquals(clientResponseDTO.email, expectedClientDto.email) },
                Executable { assertEquals(clientResponseDTO.document, expectedClientDto.document) }
        )
        clientResponseDTO.addresses!!.forEach {
            assertAll(
                    Executable { assertEquals(it.type, expectedClientDto.addresses!![0].type) },
                    Executable { assertEquals(it.area, expectedClientDto.addresses!![0].area) },
                    Executable { assertEquals(it.number, expectedClientDto.addresses!![0].number) }
            )
        }
    }
}
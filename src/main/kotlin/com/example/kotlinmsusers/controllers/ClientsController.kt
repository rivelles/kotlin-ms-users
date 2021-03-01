package com.example.kotlinmsusers.controllers

import com.example.kotlinmsusers.dtos.ClientResponseDTO
import com.example.kotlinmsusers.models.users.Client
import com.example.kotlinmsusers.repositories.ClientsRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("v1/clients")
class ClientsController {

    @Autowired
    lateinit var clientsRepository: ClientsRepository

    @GetMapping
    fun findAllUsers(): List<ClientResponseDTO> {
        return clientsRepository.findAll().map { it.toClientResponseDto() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ClientResponseDTO {
        return clientsRepository.findById(id).orElseThrow { EntityNotFoundException() }.toClientResponseDto()
    }

    @PostMapping
    fun saveUser(@RequestBody client: Client): ClientResponseDTO {
        return clientsRepository.save(client).toClientResponseDto()
    }
}
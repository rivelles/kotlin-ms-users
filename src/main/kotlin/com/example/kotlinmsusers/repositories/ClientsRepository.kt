package com.example.kotlinmsusers.repositories

import com.example.kotlinmsusers.models.users.Client
import org.springframework.data.repository.CrudRepository

interface ClientsRepository: CrudRepository<Client, Long>
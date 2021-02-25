package com.example.kotlinmsusers.repositories

import com.example.kotlinmsusers.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface UsersRepository: CrudRepository<User, Long>
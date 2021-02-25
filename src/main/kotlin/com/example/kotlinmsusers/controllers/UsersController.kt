package com.example.kotlinmsusers.controllers

import com.example.kotlinmsusers.models.User
import com.example.kotlinmsusers.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/users")
class UsersController {

    @Autowired
    lateinit var usersRepository: UsersRepository

    @GetMapping
    fun findAllUsers(): List<User> {
        return usersRepository.findAll().toList()
    }

    @PostMapping
    fun saveUser(@RequestBody user: User): User {
        return usersRepository.save(user)
    }
}
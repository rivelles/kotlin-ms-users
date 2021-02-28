package com.example.kotlinmsusers.models.users

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class User(@Id @GeneratedValue val id: Long,
                    val name: String,
                    val email: String,
                    val document: String,
                    val password: String)
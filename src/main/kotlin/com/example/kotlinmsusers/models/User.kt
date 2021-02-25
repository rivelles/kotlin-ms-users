package com.example.kotlinmsusers.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(@Id @GeneratedValue val id: Long,
           val name: String,
           val email: String)
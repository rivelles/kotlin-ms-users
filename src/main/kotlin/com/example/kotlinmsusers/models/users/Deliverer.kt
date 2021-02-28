package com.example.kotlinmsusers.models.users

import com.example.kotlinmsusers.models.orders.Delivery
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Deliverer(id: Long,
                name: String,
                email: String,
                document: String,
                password: String,
                var bankAccount: String,
                @OneToMany(fetch = FetchType.LAZY)
                var deliveries: MutableList<Delivery>): User(id, name, email, document, password)
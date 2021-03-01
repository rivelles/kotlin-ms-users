package com.example.kotlinmsusers.repositories

import com.example.kotlinmsusers.models.restaurants.Restaurant
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantsRepository: CrudRepository<Restaurant, Long>
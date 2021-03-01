package com.example.kotlinmsusers.controllers

import com.example.kotlinmsusers.dtos.RestaurantResponseDTO
import com.example.kotlinmsusers.models.restaurants.Restaurant
import com.example.kotlinmsusers.repositories.RestaurantsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/v1/restaurants")
class RestaurantsController {

    @Autowired
    lateinit var restaurantsRepository: RestaurantsRepository

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): RestaurantResponseDTO {
        return restaurantsRepository.findById(id).orElseThrow {EntityNotFoundException()}.toRestaurantResponseDto()
    }

    @PostMapping
    fun saveRestaurant(@RequestBody restaurant: Restaurant): RestaurantResponseDTO {
        return restaurantsRepository.save(restaurant).toRestaurantResponseDto()
    }
}
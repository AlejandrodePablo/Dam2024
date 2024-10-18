package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero
import retrofit2.Response
import retrofit2.http.GET

interface SuperHeroService {

    //REST API: POST, GET, PUT, DELETE, PATCH
    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHero>>

}
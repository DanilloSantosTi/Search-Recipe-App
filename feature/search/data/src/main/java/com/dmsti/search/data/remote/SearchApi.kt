package com.dmsti.search.data.remote

import com.dmsti.search.data.model.RecipeDetailsResponse
import com.dmsti.search.data.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("api/json/v1/1/search.php")
    suspend fun getRecipe(
        @Query("s") s: String
    ): Response<RecipeResponse>

    @GET("api/json/v1/1/lookup.php")
    suspend fun getRecipeDetails(
        @Query("i") id: String
    ): Response<RecipeDetailsResponse>
}

//www.themealdb.com/api/json/v1/1/search.php?s=chicken
//www.themealdb.com/api/json/v1/1/lookup.php?i=52772
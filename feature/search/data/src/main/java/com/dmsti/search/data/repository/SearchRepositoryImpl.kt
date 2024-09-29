package com.dmsti.search.data.repository

import com.dmsti.search.data.model.toListRecipe
import com.dmsti.search.data.model.toRecipeDetails
import com.dmsti.search.data.remote.SearchApi
import com.dmsti.search.domain.model.Recipe
import com.dmsti.search.domain.model.RecipeDetails
import com.dmsti.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchApi: SearchApi
) : SearchRepository {

    override suspend fun getRecipes(query: String): Result<List<Recipe>> {
        return try {
            val response = searchApi.getRecipe(query)

            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    Result.success(it.toListRecipe())
                } ?: run {
                    Result.failure(Exception("Error"))
                }
            } else {
                Result.failure(Exception("Error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun getRecipesDetails(id: String): Result<RecipeDetails> {
        return try {
            val responseDetails = searchApi.getRecipeDetails(id)

            if (responseDetails.isSuccessful) {
                responseDetails.body()?.meal?.let {
                    if (it.isNotEmpty()) {
                        Result.success(it.first().toRecipeDetails())
                    } else {
                        Result.failure(Exception("Error"))
                    }
                } ?: run {
                    Result.failure(Exception("Error"))
                }
            } else {
                Result.failure(Exception("Error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

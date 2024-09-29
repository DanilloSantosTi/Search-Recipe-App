package com.dmsti.search.domain.repository

import com.dmsti.search.domain.model.Recipe
import com.dmsti.search.domain.model.RecipeDetails

interface SearchRepository {

    suspend fun getRecipes(query: String): Result<List<Recipe>>

    suspend fun getRecipesDetails(id: String): Result<RecipeDetails>
}
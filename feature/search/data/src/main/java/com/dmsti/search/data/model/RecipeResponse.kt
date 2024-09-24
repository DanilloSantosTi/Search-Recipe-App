package com.dmsti.search.data.model

data class RecipeResponse(
    val meals: List<RecipeDTO>? = null
)

data class RecipeDetailsResponse(
    val meal: List<RecipeDTO>? = null
)
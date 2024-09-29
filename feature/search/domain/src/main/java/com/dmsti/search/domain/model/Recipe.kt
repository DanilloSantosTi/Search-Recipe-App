package com.dmsti.search.domain.model

data class Recipe(
    val idMeal: String,
    val strArea: String,
    val strMeal: String,
    val strMealThumb: String,
    val strCategory: String,
    val strTags: String?,
    val strYoutube: String?,
    val strInstructions: String,
)

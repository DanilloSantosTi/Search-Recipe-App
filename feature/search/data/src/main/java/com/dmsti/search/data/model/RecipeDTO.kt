package com.dmsti.search.data.model

import com.dmsti.search.domain.model.Recipe
import com.dmsti.search.domain.model.RecipeDetails

data class RecipeDTO(
    val dateModified: String?,
    val idMeal: String,
    val strArea: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String?,
    val strDrinkAlternate: String?,
    val strImageSource: String?,
    val strIngredient1: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient16: String?,
    val strIngredient17: String?,
    val strIngredient18: String?,
    val strIngredient19: String?,
    val strIngredient2: String?,
    val strIngredient20: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String,
    val strMeasure1: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strMeasure16: String?,
    val strMeasure17: String?,
    val strMeasure18: String?,
    val strMeasure19: String?,
    val strMeasure2: String?,
    val strMeasure20: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strSource: String?,
    val strTags: String?,
    val strYoutube: String?
)

fun List<RecipeDTO>.toListRecipe(): List<Recipe> = map {
    Recipe(
        idMeal = it.idMeal,
        strArea = it.strArea,
        strMeal = it.strMeal,
        strMealThumb = it.strMealThumb,
        strCategory = it.strCategory,
        strTags = it.strTags,
        strYoutube = it.strYoutube,
        strInstructions = it.strInstructions,
    )
}

fun RecipeDTO.toRecipeDetails(): RecipeDetails =
    RecipeDetails(
        idMeal = idMeal,
        strArea = strArea,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
        strCategory = strCategory,
        strTags = strTags,
        strYoutube = strYoutube,
        strInstructions = strInstructions,
        ingredientsPair = getIngredientPairsWithItsMeasure()
    )


fun RecipeDTO.getIngredientPairsWithItsMeasure(): List<Pair<String, String>> {
    val list = mutableListOf<Pair<String, String>>()
    list.add(Pair(strIngredient1.getOrEmpty(), strMeasure1.getOrEmpty()))
    list.add(Pair(strIngredient2.getOrEmpty(), strMeasure2.getOrEmpty()))
    list.add(Pair(strIngredient3.getOrEmpty(), strMeasure3.getOrEmpty()))
    list.add(Pair(strIngredient4.getOrEmpty(), strMeasure4.getOrEmpty()))
    list.add(Pair(strIngredient5.getOrEmpty(), strMeasure5.getOrEmpty()))
    list.add(Pair(strIngredient6.getOrEmpty(), strMeasure6.getOrEmpty()))
    list.add(Pair(strIngredient7.getOrEmpty(), strMeasure7.getOrEmpty()))
    list.add(Pair(strIngredient8.getOrEmpty(), strMeasure8.getOrEmpty()))
    list.add(Pair(strIngredient9.getOrEmpty(), strMeasure9.getOrEmpty()))
    list.add(Pair(strIngredient10.getOrEmpty(), strMeasure10.getOrEmpty()))
    list.add(Pair(strIngredient11.getOrEmpty(), strMeasure11.getOrEmpty()))
    list.add(Pair(strIngredient12.getOrEmpty(), strMeasure12.getOrEmpty()))
    list.add(Pair(strIngredient13.getOrEmpty(), strMeasure13.getOrEmpty()))
    list.add(Pair(strIngredient14.getOrEmpty(), strMeasure14.getOrEmpty()))
    list.add(Pair(strIngredient15.getOrEmpty(), strMeasure15.getOrEmpty()))
    list.add(Pair(strIngredient16.getOrEmpty(), strMeasure16.getOrEmpty()))
    list.add(Pair(strIngredient17.getOrEmpty(), strMeasure17.getOrEmpty()))
    list.add(Pair(strIngredient18.getOrEmpty(), strMeasure18.getOrEmpty()))
    list.add(Pair(strIngredient19.getOrEmpty(), strMeasure19.getOrEmpty()))
    list.add(Pair(strIngredient20.getOrEmpty(), strMeasure20.getOrEmpty()))
    return list
}

fun String?.getOrEmpty() = this?.ifEmpty { "" } ?: ""



package com.dmsti.search.domain.usecase

import com.dmsti.common.utils.NetworkResult
import com.dmsti.search.domain.model.RecipeDetails
import com.dmsti.search.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetRecipeDetailsUseCase @Inject constructor(private val searchRepository: SearchRepository) {
    operator fun invoke(id: String) = flow<NetworkResult<RecipeDetails>> {
        emit(NetworkResult.Loading())
        val response = searchRepository.getRecipesDetails(id)
        if (response.isSuccess) {
            emit(NetworkResult.Success(data = response.getOrThrow()))
        } else {
            emit(NetworkResult.Error(response.exceptionOrNull()?.localizedMessage))
        }
    }.catch {
        emit(NetworkResult.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}

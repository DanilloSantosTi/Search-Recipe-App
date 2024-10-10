package com.dmsti.search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmsti.common.utils.NetworkResult
import com.dmsti.common.utils.UiText
import com.dmsti.search.domain.usecase.GetRecipeDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import com.dmsti.search.domain.model.RecipeDetails
import kotlinx.coroutines.flow.launchIn

class RecipeDetailsViewModel @Inject constructor(
    private val getRecipeDetailsUseCase: GetRecipeDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeDetailsObj.UiState())
    private val uiState: StateFlow<RecipeDetailsObj.UiState> get() = _uiState

    fun onEvent(event: RecipeDetailsObj.Event) {
        when (event) {
            is RecipeDetailsObj.Event.GetRecipeDetailsId -> {
                getRecipeDetails(id = event.id)
            }
        }
    }

    private fun getRecipeDetails(id: String) = getRecipeDetailsUseCase.invoke(id)
        .onEach { result ->
            when (result) {
                is NetworkResult.Loading -> {
                    _uiState.update { RecipeDetailsObj.UiState(isLoading = true) }
                }

                is NetworkResult.Error -> {
                    _uiState.update {
                        RecipeDetailsObj.UiState(
                            error = UiText.RemoteString(result.message.toString())
                        )
                    }
                }

                is NetworkResult.Success -> {
                    _uiState.update { RecipeDetailsObj.UiState(data = result.data) }
                }
            }
        }.launchIn(viewModelScope)
}

object RecipeDetailsObj {
    data class UiState(
        val isLoading: Boolean = false,
        val error: UiText = UiText.Idle,
        val data: RecipeDetails? = null
    )

    sealed interface Navigation {

    }

    sealed interface Event {
        data class GetRecipeDetailsId(val id: String) : Event
    }
}
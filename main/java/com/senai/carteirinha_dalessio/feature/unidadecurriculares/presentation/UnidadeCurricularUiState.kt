package com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val listaUnidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}
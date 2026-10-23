package com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.repository

import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.model.UnidadeCurricular


interface UnidadeCurricularRepository {
    suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>>
}
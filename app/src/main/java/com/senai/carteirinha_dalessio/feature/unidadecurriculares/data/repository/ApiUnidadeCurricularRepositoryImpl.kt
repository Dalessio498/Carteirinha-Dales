package com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.repository

import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.model.UnidadeCurricular
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.repository.UnidadeCurricularRepository
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import okio.IOException
import retrofit2.HttpException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: UnidadeCurricularApi
): UnidadeCurricularRepository {
    override suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>> {
        return runCatching {
            api.listarUnidadesCurriculares().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when(throwable){
                is HttpException ->{
                    if (throwable.code()==401){
                        IllegalStateException("Sua sessão expirou. Faça logn novamente")
                    }else{
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()})")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possivel conectar na API")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares")
            }

        }

    }

}
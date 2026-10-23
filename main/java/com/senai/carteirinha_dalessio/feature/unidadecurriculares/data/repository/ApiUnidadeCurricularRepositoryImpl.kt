package com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.repository

import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.model.UnidadeCurricular
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.repository.UnidadeCurricularRepository
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import retrofit2.HttpException
import java.io.IOException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: UnidadeCurricularApi
) : UnidadeCurricularRepository {

    override suspend fun listarUnidadesCurriculares():
            Result<List<UnidadeCurricular>> {

        return runCatching {

            api
                .listarUnidadesCurriculares()
                .map { dto ->

                    dto.toDomain()
                }

        }.recoverCatching { throwable ->

            throw when (throwable) {

                is HttpException -> {

                    when (throwable.code()) {

                        401 ->
                            IllegalStateException(
                                "Sessão inválida ou expirada. Faça login novamente."
                            )

                        403 ->
                            IllegalStateException(
                                "Você não tem permissão para acessar as unidades curriculares."
                            )

                        else ->
                            IllegalStateException(
                                "Erro ao carregar unidades curriculares (${throwable.code()})."
                            )
                    }
                }

                is IOException ->
                    IllegalStateException(
                        "Não foi possível conectar à API."
                    )

                else ->
                    IllegalStateException(
                        throwable.message
                            ?: "Erro ao carregar unidades curriculares."
                    )
            }
        }
    }
}
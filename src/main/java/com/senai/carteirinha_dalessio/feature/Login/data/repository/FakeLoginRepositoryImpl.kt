package com.senai.carteirinha_dalessio.feature.Login.data.repository

import com.senai.carteirinha_dalessio.feature.Login.domain.model.UsuarioLogado
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class FakeLoginRepositoryImpl : LoginRepository {
    override suspend fun login(
        usuario: String,
        senha: String
    ): Result<UsuarioLogado> {
        delay(1500.milliseconds)

        return if(usuario.equals("aluno") && senha.equals("123")) {
            Result.success(
                UsuarioLogado(
                    id = "1",
                    nome = "Willian Gama",
                    curso = "Desenvolvimento de sistemas",
                    turma = "2DEVEST-B",
                    token = "token-fake-para-aula"
                )
            )
        } else {
            Result.failure(
                IllegalArgumentException("Coloca os bagulho direito caralho")
            )
        }
    }
}

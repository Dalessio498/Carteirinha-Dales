package com.senai.carteirinha_dalessio.feature.Login.data.repository

import com.senai.carteirinha_dalessio.feature.Login.data.remote.dto.LoginRequestDto
import com.senai.carteirinha_dalessio.feature.Login.data.remote.dto.LoginResponseDto
import com.senai.carteirinha_dalessio.feature.Login.data.remote.service.AuthApi
import com.senai.carteirinha_dalessio.feature.Login.domain.model.PerfilAcesso
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ApiLoginRepositoryImplTest {
    private fun repository(nome: String, perfil: String, matricula: String) =
        ApiLoginRepositoryImpl(object : AuthApi {
            override suspend fun login(body: LoginRequestDto) = LoginResponseDto(
                id = "00000000-0000-0000-0000-000000000001",
                nome = nome,
                matricula = matricula,
                perfil = perfil,
                curso = "Desenvolvimento de Sistemas",
                turma = "2DEVEST-A",
                token = "token-de-teste"
            )
        })

    @Test
    fun loginAlunoPreservaIdentidadeEPerfilDaApi() = runBlocking {
        val user = repository("Rafael Costa", "ALUNO", "2026000001")
            .login("aluno", "123").getOrThrow()

        assertEquals("Rafael Costa", user.nome)
        assertEquals("2026000001", user.matricula)
        assertEquals(PerfilAcesso.ALUNO, user.perfil)
    }

    @Test
    fun loginMariaPreservaIdentidadeEPerfilDaApi() = runBlocking {
        val user = repository("Maria Oliveira", "ALUNO", "2026000002")
            .login("maria", "456").getOrThrow()

        assertEquals("Maria Oliveira", user.nome)
        assertEquals("2026000002", user.matricula)
        assertEquals(PerfilAcesso.ALUNO, user.perfil)
    }

    @Test
    fun loginProfessorMantemPerfilProfessor() = runBlocking {
        val user = repository("Professor Modelo", "PROFESSOR", "PROF20260001")
            .login("professor", "123").getOrThrow()

        assertEquals("Professor Modelo", user.nome)
        assertEquals(PerfilAcesso.PROFESSOR, user.perfil)
    }

    @Test
    fun perfilInvalidoNaoViraAlunoAutomaticamente() = runBlocking {
        val result = repository("Teste", "INVALIDO", "1").login("teste", "123")
        assertTrue(result.isFailure)
    }
}

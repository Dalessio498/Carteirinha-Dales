package com.senai.carteirinha_dalessio.feature.Login.data.repository

import com.senai.carteirinha_dalessio.feature.Login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(usuario: String, senha: String): Result<UsuarioLogado>
}
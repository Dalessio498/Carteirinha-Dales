package com.senai.carteirinha_dalessio.App.di

import com.senai.carteirinha_dalessio.Core.auth.AuthTokenStore
import com.senai.carteirinha_dalessio.feature.Login.data.repository.LoginRepository
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}
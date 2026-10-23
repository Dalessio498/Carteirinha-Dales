package com.senai.carteirinha_dalessio.App.di

import com.senai.carteirinha_dalessio.Core.auth.AuthTokenStore
import com.senai.carteirinha_dalessio.Core.auth.InMemoryAuthTokenStore
import com.senai.carteirinha_dalessio.Core.network.NetworkClient
import com.senai.carteirinha_dalessio.feature.Login.data.remote.service.AuthApi
import com.senai.carteirinha_dalessio.feature.Login.data.repository.ApiLoginRepositoryImpl
import com.senai.carteirinha_dalessio.feature.Login.data.repository.LoginRepository
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.repository.UnidadeCurricularRepository
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl

class DefaultAppContainer : AppContainer {
    override val authTokenStore: AuthTokenStore = InMemoryAuthTokenStore()
    private val publicClient = NetworkClient(BASE_URL)
    private val authenticatedClient = NetworkClient(BASE_URL, authTokenStore)
    private val authApi: AuthApi by lazy { publicClient.create(AuthApi::class.java) }
    private val ucApi: UnidadeCurricularApi by lazy { authenticatedClient.create(UnidadeCurricularApi::class.java) }

    override val loginRepository: LoginRepository by lazy {
        ApiLoginRepositoryImpl(authApi)
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(ucApi)
    }
    companion object {
        // 10.0.2.2 corresponde ao computador host no emulador Android.
        private const val BASE_URL = "http://10.0.2.2:8080/"
    }
}

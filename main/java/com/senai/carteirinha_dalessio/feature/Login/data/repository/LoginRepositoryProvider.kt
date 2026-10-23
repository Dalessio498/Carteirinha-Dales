package com.senai.carteirinha_dalessio.feature.Login.data.repository

import com.senai.carteirinha_dalessio.feature.Login.data.remote.network.NetworkFactory

object LoginRepositoryProvider {
    private const val USE_FAKE_REPOSITORY = false

    fun provide(): LoginRepository {
        return if (USE_FAKE_REPOSITORY) {
            FakeLoginRepositoryImpl()
        } else {
            ApiLoginRepositoryImpl(NetworkFactory.createAuthApi())
        }
    }
}
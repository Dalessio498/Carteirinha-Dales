package com.senai.carteirinha_dalessio.feature.Login.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val login: String,
    val senha: String
)
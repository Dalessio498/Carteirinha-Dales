package com.senai.carteirinha_dalessio.feature.Login.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    val message: String? = null
)
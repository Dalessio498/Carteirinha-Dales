package com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.senai.carteirinha_dalessio.R

@Composable
fun PerfilAluno(
    nome: String,
    curso: String,
    idFoto: Int = R.drawable.img_2
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(10.dp)
    ) {

        Image(
            painter = painterResource(id = idFoto),
            contentDescription = "Foto de Perfil",
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    Color.White,
                    CircleShape
                )
        )

        InfoAluno(textLabel = "Nome: ", textValue = nome)

        InfoAluno(textLabel = "Curso: ", textValue = curso)
    }
}
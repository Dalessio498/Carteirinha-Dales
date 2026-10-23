package com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalBlue
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalOrange
import com.senai.carteirinha_dalessio.R
import com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.component.QrCode
import com.senai.carteirinha_dalessio.feature.Login.domain.model.UsuarioLogado

@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier,
    usuario: UsuarioLogado
) {
    val iniciais = usuario.nome.trim().split(" ")
        .filter { it.isNotBlank() }
        .take(2)
        .joinToString("") { it.take(1) }
        .uppercase()
        .ifBlank { "A" }

    Column(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "IDENTIFICAÇÃO DIGITAL",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    "Minha carteirinha",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Image(
                painter = painterResource(R.drawable.logo_senai),
                contentDescription = "Logo SENAI",
                modifier = Modifier.width(108.dp)
            )
        }

        Spacer(Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth().widthIn(max = 460.dp),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PortalBlue)
                        .padding(horizontal = 22.dp, vertical = 17.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "SENAI  /  ID DIGITAL",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Surface(shape = RoundedCornerShape(50), color = PortalOrange) {
                        Text(
                            text = "ATIVO",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp),
                            color = Color(0xFF211000),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth().padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(96.dp)
                            .border(3.dp, PortalOrange, CircleShape)
                            .padding(5.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = iniciais,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = usuario.nome,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = usuario.curso.ifBlank { "Curso não informado" },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(Modifier.height(22.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline)
                    Spacer(Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                "MATRÍCULA",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                usuario.matricula.ifBlank { "Não informada" },
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                "TURMA",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                usuario.turma.ifBlank { "Não informada" },
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                    Spacer(Modifier.height(22.dp))
                    Surface(
                        shape = RoundedCornerShape(22.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        if (usuario.matricula.isNotBlank()) {
                            QrCode(
                                conteudo = usuario.matricula,
                                modifier = Modifier.padding(18.dp).size(164.dp)
                            )
                        } else {
                            Text(
                                text = "QR Code indisponível",
                                modifier = Modifier.padding(28.dp),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    Spacer(Modifier.height(13.dp))
                    Text(
                        text = "Apresente o QR Code para sua identificação.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        Spacer(Modifier.height(22.dp))
        Text(
            "Documento digital vinculado ao seu acesso.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
    }
}

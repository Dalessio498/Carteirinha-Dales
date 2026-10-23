package com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularScreen(
    viewModel: UnidadeCurricularViewModel,
    modifier: Modifier = Modifier
) {

    val uiState by
    viewModel.uiState
        .collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {

        viewModel.carregar()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(
                horizontal = 20.dp
            )
    ) {

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Unidades Curriculares",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text =
                "Acompanhe suas notas e frequência",
            style =
                MaterialTheme.typography.bodyLarge,
            color =
                MaterialTheme
                    .colorScheme
                    .onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        when {

            uiState.isLoading -> {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment =
                        Alignment.Center
                ) {

                    CircularProgressIndicator()
                }
            }

            uiState.errorMessage != null -> {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment =
                        Alignment.Center
                ) {

                    Column(
                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Text(
                            text =
                                uiState.errorMessage
                                    ?: "Erro desconhecido",
                            color =
                                MaterialTheme
                                    .colorScheme
                                    .error
                        )

                        Spacer(
                            modifier =
                                Modifier.height(16.dp)
                        )

                        Button(
                            onClick = {
                                viewModel.carregar()
                            }
                        ) {

                            Text(
                                text = "Tentar novamente"
                            )
                        }
                    }
                }
            }

            uiState
                .listaUnidadesCurriculares
                .isEmpty() -> {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(
                        text =
                            "Nenhuma unidade curricular encontrada.",
                        color =
                            MaterialTheme
                                .colorScheme
                                .onSurfaceVariant
                    )
                }
            }

            else -> {

                LazyColumn(
                    modifier =
                        Modifier.fillMaxSize(),
                    verticalArrangement =
                        Arrangement.spacedBy(
                            14.dp
                        ),
                    contentPadding =
                        PaddingValues(
                            bottom = 24.dp
                        )
                ) {

                    items(
                        uiState
                            .listaUnidadesCurriculares
                    ) { unidade ->

                        UnidadeCurricularCard(
                            unidadeCurricular =
                                unidade
                        )
                    }
                }
            }
        }
    }
}
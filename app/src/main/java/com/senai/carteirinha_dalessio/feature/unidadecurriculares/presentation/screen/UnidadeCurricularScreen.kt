package com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(viewModel) { viewModel.carregar() }

    Column(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 20.dp, vertical = 22.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(50),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Text(
                "ACOMPANHAMENTO ACADÊMICO",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        Spacer(Modifier.height(14.dp))
        Text("Unidades curriculares", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(6.dp))
        Text(
            "Acompanhe suas notas, médias e frequência.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(22.dp))

        when {
            state.isLoading -> {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(10.dp))
                Text("Buscando suas unidades curriculares...")
            }

            state.errorMessage != null -> {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
                ) {
                    Column(Modifier.padding(20.dp)) {
                        Text(
                            text = state.errorMessage ?: "Não foi possível consultar a API.",
                            color = MaterialTheme.colorScheme.onErrorContainer
                        )
                        Spacer(Modifier.height(12.dp))
                        Button(onClick = { viewModel.carregar() }) {
                            Text("Tentar novamente")
                        }
                    }
                }
            }

            state.listaUnidadesCurriculares.isEmpty() -> {
                Card(shape = RoundedCornerShape(18.dp)) {
                    Text(
                        text = "Nenhuma unidade curricular encontrada.",
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }

            else -> LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(
                    items = state.listaUnidadesCurriculares,
                    key = { it.id }
                ) { unidade ->
                    UnidadeCurricularCard(unidadeCurricular = unidade)
                }
            }
        }
    }
}

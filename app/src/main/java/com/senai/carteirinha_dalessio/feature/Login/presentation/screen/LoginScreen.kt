package com.senai.carteirinha_dalessio.feature.Login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalBlue
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalBlueDark
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalOrange
import com.senai.carteirinha_dalessio.R
import com.senai.carteirinha_dalessio.feature.Login.domain.model.UsuarioLogado
import com.senai.carteirinha_dalessio.feature.Login.presentation.LoginEvent
import com.senai.carteirinha_dalessio.feature.Login.presentation.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onLoginSucesso: (UsuarioLogado) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.logo_senai),
                contentDescription = "Logo SENAI",
                modifier = Modifier.width(124.dp)
            )
            Surface(
                shape = RoundedCornerShape(50),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = "PORTAL DIGITAL",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        Surface(
            shape = RoundedCornerShape(28.dp),
            shadowElevation = 4.dp,
            color = PortalBlue
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(listOf(PortalBlue, PortalBlueDark))
                    )
                    .padding(26.dp)
            ) {
                Box(
                    Modifier.width(48.dp).height(5.dp)
                        .background(PortalOrange, RoundedCornerShape(50))
                )
                Spacer(Modifier.height(24.dp))
                Text(
                    text = "Tudo do seu curso,\nem um só lugar.",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Carteirinha, notas e informações acadêmicas sempre ao seu alcance.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFE2ECFF)
                )
            }
        }

        Spacer(Modifier.height(22.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(22.dp)) {
                Text(
                    text = "Entrar na conta",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Use seu usuário e sua senha.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(22.dp))

                OutlinedTextField(
                    value = uiState.usuario,
                    onValueChange = { viewModel.onEvent(LoginEvent.OnUsuarioChange(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Usuário") },
                    placeholder = { Text("Seu usuário") },
                    singleLine = true,
                    enabled = !uiState.isLoading,
                    shape = RoundedCornerShape(16.dp),
                    isError = uiState.erroMensage != null,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                )
                Spacer(Modifier.height(16.dp))
                OutlinedTextField(
                    value = uiState.senha,
                    onValueChange = { viewModel.onEvent(LoginEvent.OnSenhaChange(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Senha") },
                    placeholder = { Text("Sua senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    enabled = !uiState.isLoading,
                    shape = RoundedCornerShape(16.dp),
                    isError = uiState.erroMensage != null,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { if (!uiState.isLoading) viewModel.onEvent(LoginEvent.OnEntrarClick) }
                    )
                )

                uiState.erroMensage?.let { erro ->
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = erro,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(Modifier.height(22.dp))
                Button(
                    onClick = { viewModel.onEvent(LoginEvent.OnEntrarClick) },
                    modifier = Modifier.fillMaxWidth().height(54.dp),
                    enabled = !uiState.isLoading,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    if (uiState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(22.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Text("ACESSAR MEU PORTAL", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(Modifier.height(26.dp))
        Text(
            text = "Carteirinha Digital • Portal acadêmico",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(12.dp))
    }
}

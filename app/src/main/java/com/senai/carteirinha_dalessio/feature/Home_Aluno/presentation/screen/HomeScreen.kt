package com.senai.carteirinha_dalessio.feature.Home_Aluno.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senai.carteirinha_dalessio.App.Navigation.Routes
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalBlue
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalBlueDark
import com.senai.carteirinha_dalessio.Core.designSystem.Theme.PortalOrange
import com.senai.carteirinha_dalessio.R
import com.senai.carteirinha_dalessio.feature.Home_Aluno.component.BotaoNavegacao
import com.senai.carteirinha_dalessio.feature.Login.domain.model.UsuarioLogado

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    usuario: UsuarioLogado,
    onLogout: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 22.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "PORTAL ACADÊMICO",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "Área do estudante",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Image(
                painter = painterResource(R.drawable.logo_senai),
                contentDescription = "Logo SENAI",
                modifier = Modifier.width(112.dp)
            )
        }

        Spacer(Modifier.height(28.dp))

        Card(
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = PortalBlue),
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.linearGradient(listOf(PortalBlue, PortalBlueDark)))
                    .padding(24.dp)
            ) {
                Surface(
                    color = PortalOrange,
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = "ALUNO",
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                        color = Color(0xFF211000),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Spacer(Modifier.height(22.dp))
                Text(
                    text = "Olá, ${usuario.nome.substringBefore(' ')}!",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = usuario.nome,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = usuario.curso.ifBlank { "Curso não informado" },
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFE3EDFF)
                )
            }
        }

        Spacer(Modifier.height(18.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Row(
                modifier = Modifier.padding(18.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "MATRÍCULA",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        usuario.matricula.ifBlank { "Não informada" },
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                VerticalDivider(
                    modifier = Modifier.height(46.dp),
                    color = MaterialTheme.colorScheme.outline
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "TURMA",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        usuario.turma.ifBlank { "Não informada" },
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        Spacer(Modifier.height(28.dp))
        Text("Acesso rápido", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(5.dp))
        Text(
            "Consulte suas informações em poucos toques.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))

        BotaoNavegacao(
            text = "Minha carteirinha",
            onClick = { navController.navigate(Routes.Carteirinha.route) }
        )
        Spacer(Modifier.height(12.dp))
        BotaoNavegacao(
            text = "Unidades curriculares",
            onClick = { navController.navigate(Routes.UnidadeCurricularAluno.route) }
        )

        Spacer(Modifier.height(28.dp))
        OutlinedButton(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Sair da conta")
        }
        Spacer(Modifier.height(12.dp))
    }
}

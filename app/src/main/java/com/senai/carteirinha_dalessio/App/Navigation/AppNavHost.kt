package com.senai.carteirinha_dalessio.App.Navigation

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinha_dalessio.App.di.AppContainer
import com.senai.carteirinha_dalessio.App.session.SessionViewModel
import com.senai.carteirinha_dalessio.feature.Login.domain.model.PerfilAcesso
import com.senai.carteirinha_dalessio.feature.Login.presentation.LoginViewModel
import com.senai.carteirinha_dalessio.feature.Login.presentation.LoginViewModelFactory
import com.senai.carteirinha_dalessio.feature.Login.presentation.screen.LoginScreen
import com.senai.carteirinha_dalessio.feature.Home_Aluno.presentation.screen.HomeScreen
import com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.screen.CarteirinhaScreen
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.factory.UnidadeCurricularViewModelFactory
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.senai.carteirinha_dalessio.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen
import com.senai.carteirinha_dalessio.professor.*

@Composable
fun AppNavHost(navController: NavHostController, container: AppContainer) {
    val factory = remember(container.authTokenStore) {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SessionViewModel(container.authTokenStore) as T
            }
        }
    }
    val session: SessionViewModel = viewModel(factory = factory)
    val usuario by session.usuarioLogado.collectAsStateWithLifecycle()

    fun sair() {
        session.limparSession()
        navController.navigate(Routes.Login.route) {
            popUpTo(Routes.Login.route) { inclusive = true }
            launchSingleTop = true
        }
    }
    NavHost(navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            val loginFactory = remember(container.loginRepository) { LoginViewModelFactory(container.loginRepository) }
            val loginVm: LoginViewModel = viewModel(factory = loginFactory)
            LoginScreen(navController = navController, viewModel = loginVm, onLoginSucesso = { user ->
                session.setUsuarioLogado(user)
                val destination = if (user.perfil == PerfilAcesso.PROFESSOR) Routes.Home_Professor.route else Routes.Home_Aluno.route
                navController.navigate(destination) {
                    popUpTo(Routes.Login.route) { inclusive = true }
                    launchSingleTop = true
                }
            })
        }
        composable(Routes.Home_Aluno.route) {
            val user = usuario
            if (user?.perfil == PerfilAcesso.ALUNO) HomeScreen(navController, modifier = androidx.compose.ui.Modifier, usuario = user, onLogout = ::sair)
            else LaunchedEffect(user) { navController.navigate(Routes.Login.route) }
        }
        composable(Routes.Carteirinha.route) {
            val user = usuario
            if (user?.perfil == PerfilAcesso.ALUNO) CarteirinhaScreen(usuario = user)
            else LaunchedEffect(user) { navController.navigate(Routes.Login.route) }
        }
        composable(Routes.UnidadeCurricularAluno.route) {
            if (usuario?.perfil == PerfilAcesso.ALUNO) {
                val ucFactory = remember(container.unidadeCurricularRepository) { UnidadeCurricularViewModelFactory(container.unidadeCurricularRepository) }
                val vm: UnidadeCurricularViewModel = viewModel(factory = ucFactory)
                UnidadeCurricularScreen(viewModel = vm)
            } else LaunchedEffect(usuario) { navController.navigate(Routes.Login.route) }
        }
        composable(Routes.Home_Professor.route) {
            val user = usuario
            if (user?.perfil == PerfilAcesso.PROFESSOR) HomeProfessor(navController, modifier = androidx.compose.ui.Modifier, usuario = user, onLogout = ::sair)
            else LaunchedEffect(user) { navController.navigate(Routes.Login.route) }
        }
        composable(Routes.TurmasProfessor.route) {
            if (usuario?.perfil == PerfilAcesso.PROFESSOR) TurmasProfessorScreen()
            else LaunchedEffect(usuario) { navController.navigate(Routes.Login.route) }
        }
        composable(Routes.UnidadeCurricularProfessor.route) {
            if (usuario?.perfil == PerfilAcesso.PROFESSOR) UnidadeCurricularProfessorScreen()
            else LaunchedEffect(usuario) { navController.navigate(Routes.Login.route) }
        }
    }
}

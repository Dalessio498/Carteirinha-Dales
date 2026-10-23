package com.senai.carteirinha_dalessio.App.Navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home_Aluno : Routes("homeAluno")
    object Carteirinha : Routes("carteirinha")
    object UnidadeCurricularAluno : Routes("unidade_curricular_aluno")
    object Home_Professor : Routes("HomeProfessor")
    object UnidadeCurricularProfessor : Routes("UCProfessor")
    object TurmasProfessor : Routes("TurmasProfessor")
}
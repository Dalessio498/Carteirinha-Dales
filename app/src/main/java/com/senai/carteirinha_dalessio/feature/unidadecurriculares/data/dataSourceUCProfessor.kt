package com.senai.carteirinha_dalessio.feature.unidadecurriculares.data

import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.model.UnidadeCurricularProfessor

fun dataSourceProfessor(): List<UnidadeCurricularProfessor>{
    return listOf(
        UnidadeCurricularProfessor(
            nome = "Desenvolvimento de Aplicações",
            turma = "1º Semestre - DS",
            cargaHoraria = "120 horas",
            quantidadeAulas = "96 aulas",
            dias = "Segunda e Quarta"
        ),

        UnidadeCurricularProfessor(
            nome = "Programação de Aplicativos Mobile",
            turma = "2º Semestre - DS",
            cargaHoraria = "80 horas",
            quantidadeAulas = "64 aulas",
            dias = "Terça e Quinta"
        ),

        UnidadeCurricularProfessor(
            nome = "Banco de Dados",
            turma = "3º Semestre - DS",
            cargaHoraria = "100 horas",
            quantidadeAulas = "80 aulas",
            dias = "Segunda e Sexta"
        ),

        UnidadeCurricularProfessor(
            nome = "Desenvolvimento de Sistemas Web",
            turma = "2º Semestre - DS",
            cargaHoraria = "90 horas",
            quantidadeAulas = "72 aulas",
            dias = "Quarta e Sexta"
        ),

        UnidadeCurricularProfessor(
            nome = "Desenvolvimento de Aplicações",
            turma = "1º Semestre - DS",
            cargaHoraria = "120 horas",
            quantidadeAulas = "96 aulas",
            dias = "Segunda e Quarta"
        ),

        UnidadeCurricularProfessor(
            nome = "Programação de Aplicativos Mobile",
            turma = "2º Semestre - DS",
            cargaHoraria = "80 horas",
            quantidadeAulas = "64 aulas",
            dias = "Terça e Quinta"
        ),

        UnidadeCurricularProfessor(
            nome = "Banco de Dados",
            turma = "3º Semestre - DS",
            cargaHoraria = "100 horas",
            quantidadeAulas = "80 aulas",
            dias = "Segunda e Sexta"
        ),

        UnidadeCurricularProfessor(
            nome = "Desenvolvimento de Sistemas Web",
            turma = "2º Semestre - DS",
            cargaHoraria = "90 horas",
            quantidadeAulas = "72 aulas",
            dias = "Quarta e Sexta"
        ),
    )
}
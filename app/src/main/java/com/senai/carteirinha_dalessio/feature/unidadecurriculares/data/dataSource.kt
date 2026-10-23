package com.senai.carteirinha_dalessio.feature.unidadecurriculares.data

import com.senai.carteirinha_dalessio.feature.unidadecurriculares.Domain.model.UnidadeCurricular

fun dataSource (): List<UnidadeCurricular> {
    return listOf(
        UnidadeCurricular(id = "1", nome = "Matematica", professor = "Marcio", nota1 = 8.0, nota2 = 8.0, media = 8.0, faltas = 10),
        UnidadeCurricular(id = "2",nome = "Portugues",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "3",nome = "Banco de Dados",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "4",nome = "Ciências",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "5",nome = "Fisica",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "6",nome = "Biologia",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "7",nome = "Matemática 2",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "8",nome = "Matemática 3",professor = "Dr. Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2)
    )
}
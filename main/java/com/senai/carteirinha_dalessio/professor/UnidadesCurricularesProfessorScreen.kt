//package com.senai.carteirinha_dalessio.professor
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.senai.carteirinha_dalessio.feature.unidadecurriculares.data.dataSourceProfessor
//
//@Composable
//fun UnidadeCurricularProfessorScreen(
//    modifier: Modifier = Modifier
//) {
//
//    val unidades = dataSourceProfessor()
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(Color(0xFFF5F5F5))
//            .padding(horizontal = 16.dp)
//    ) {
//
//        Spacer(
//            modifier = Modifier.height(16.dp)
//        )
//
//        Text(
//            text = "Un. Curriculares",
//            fontSize = 28.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF29457D)
//        )
//
//        Spacer(
//            modifier = Modifier.height(20.dp)
//        )
//
//        LazyColumn(
//            verticalArrangement = Arrangement.spacedBy(14.dp)
//        ) {
//
//            items(unidades) { unidade ->
//
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .shadow(
//                            elevation = 15.dp,
//                            shape = RoundedCornerShape(8.dp),
//                            clip = false,
//                            ambientColor = Color(0xFFFF643C),
//                            spotColor = Color(0xFFFF643C)
//                        ),
//
//                    shape = RoundedCornerShape(16.dp),
//
//                    colors = CardDefaults.cardColors(
//                        containerColor = Color(0xFFF2F0F5)
//                    ),
//
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 4.dp,
//                    ),
//
//                ) {
//
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    ) {
//
//                        Text(
//                            text = unidade.nome,
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Normal,
//                            color = Color(0xFF3F3F46)
//                        )
//
//                        Spacer(
//                            modifier = Modifier.height(10.dp)
//                        )
//
//                        Text(
//                            text = "Turma: ${unidade.turma}",
//                            fontSize = 13.sp,
//                            color = Color(0xFF44444A)
//                        )
//
//                        Spacer(
//                            modifier = Modifier.height(8.dp)
//                        )
//
//                        Text(
//                            text = "Carga horária: ${unidade.cargaHoraria}",
//                            fontSize = 13.sp,
//                            color = Color(0xFF44444A)
//                        )
//
//                        Spacer(
//                            modifier = Modifier.height(8.dp)
//                        )
//
//                        Text(
//                            text = "Total de aulas: ${unidade.quantidadeAulas}",
//                            fontSize = 13.sp,
//                            color = Color(0xFF44444A)
//                        )
//
//                        Spacer(
//                            modifier = Modifier.height(8.dp)
//                        )
//
//                        Text(
//                            text = "Dias: ${unidade.dias}",
//                            fontSize = 13.sp,
//                            color = Color(0xFF55505E)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
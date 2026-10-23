//package com.senai.carteirinha_dalessio.professor
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.senai.carteirinha_dalessio.feature.Home_Aluno.component.BotaoNavegacao
//import com.senai.carteirinha_dalessio.App.Navigation.Routes
//import com.senai.carteirinha_dalessio.R
//
//@Composable
//fun HomeProfessor(
//    navController: NavController,
//    modifier: Modifier
//) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(horizontal = 30.dp),
//
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Spacer(modifier = Modifier.height(50.dp))
//
//        Text(
//            text = "Olá Professor!",
//            fontSize = 32.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF2145B5)
//        )
//
//        Spacer(modifier = Modifier.height(60.dp))
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Prof. Willian Gama",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Gray
//            )
//
//            Box(
//                modifier = Modifier
//                    .width(250.dp)
//                    .height(2.dp)
//                    .background(Color(0xFFFF643C))
//            )
//
//
//            Spacer(modifier = Modifier.height(35.dp))
//
//
//            Text(
//                text = "SENAI Anchieta",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Gray
//            )
//
//            Box(
//                modifier = Modifier
//                    .width(250.dp)
//                    .height(2.dp)
//                    .background(Color(0xFFFF643C))
//            )
//        }
//
//        Spacer(modifier = Modifier.height(80.dp))
//
//        BotaoNavegacao("Minhas Turmas", onClick = {
//            navController.navigate(Routes.TurmasProfessor.route)
//        })
//
//        Spacer(modifier = Modifier.height(35.dp))
//
//        BotaoNavegacao("UCs", onClick = {
//            navController.navigate(Routes.UnidadeCurricularProfessor.route)
//        })
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        Image(
//            painter = painterResource(id = R.drawable.logo_senai),
//            contentDescription = "Logo SENAI",
//            modifier = Modifier.width(190.dp)
//        )
//
//        Spacer(modifier = Modifier.height(25.dp))
//    }
//}

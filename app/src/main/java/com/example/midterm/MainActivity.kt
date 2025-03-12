package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.midterm.ui.theme.MidTermTheme
import androidx.compose.animation.core.animateFloatAsState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidTermTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "firstScreen") {
                    composable("firstScreen") { FirstScreen(navController)}
                    composable("secondScreen") { SecondScreen() }
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Мое хобби - фотографировать", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible) {
            Text("Мне нравится фотографировать людей и природу", style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("secondScreen")}) {
            Text("Примеры: ")
        }
    }
}

@Composable
fun SecondScreen() {
    var isZoomed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(targetValue = if (isZoomed) 1.5f else 1f).value
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Crossfade(targetState = isZoomed) { zoomed ->
            Text(if (zoomed) "Увеличенное фото" else "Обычный вид", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.taking_photo),
            contentDescription = "Фото",
            modifier = Modifier
                .size(200.dp)
                .scale(scale)
                .clickable { isZoomed = !isZoomed }
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    MidTermTheme { FirstScreen(rememberNavController()) }
}
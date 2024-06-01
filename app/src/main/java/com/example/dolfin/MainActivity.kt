package com.example.dolfin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.activity.ComponentActivity
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.Observer
import com.example.dolfin.databinding.ActivityMainBinding
import com.example.dolfin.model.NewsResponse
import com.example.dolfin.model.NewsViewModel
import com.example.dolfin.ui.MainScreen
import com.example.dolfin.ui.screens.NewsplashScreen

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}
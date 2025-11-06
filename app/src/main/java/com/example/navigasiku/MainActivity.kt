package com.example.navigasiku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.navigasiku.ui.theme.NavigasiKuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigasiKuTheme {
                // 🔹 Panggil composable utama yang mengatur navigasi
                DataApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

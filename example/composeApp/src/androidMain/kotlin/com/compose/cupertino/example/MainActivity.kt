package com.compose.cupertino.example

import App
import DefaultRootComponent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val context = defaultComponentContext()
        val component = DefaultRootComponent(context)
        setContent {
            App(component)
        }
    }
}

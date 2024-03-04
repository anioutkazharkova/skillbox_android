package com.example.helloskillboxcompose2.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SecondScreen(text: String = "Some") {
    Text(text = "Hello from $text")
}

@Composable
@Preview(showBackground = true)
fun SecondScreenPreview() {
    SecondScreen(text = "Hi")
}
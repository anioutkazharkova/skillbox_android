package com.example.helloskillboxcompose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloskillboxcompose2.ui.theme.HelloSkillboxCompose2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloSkillboxCompose2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    App()//FirstScreen("Hello, Skillbox")
                }
            }
        }
    }
}

@Composable
fun FirstScreen(text: String, modifier: Modifier = Modifier, onClick: (String) -> Unit = {}) {
    val painter = painterResource(id = R.drawable.kitten)
    Row(
        modifier = modifier.padding(
            horizontal = 10.dp,
            vertical = 20.dp
        )
    ) {
        Image(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = "Kitten"
        )
        Column {
            Button(onClick = {
                onClick.invoke("Skillbox")
            }) {
                Text(text = "Click", modifier = Modifier)
            }
            TextView(text = text, modifier = Modifier.padding(horizontal = 10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen("Hello")
}

@Composable
fun TextView(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 20.sp,
        modifier = modifier.padding(top = 10.dp)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TextViewPreview() {
    HelloSkillboxCompose2Theme {
        TextView(text = "Hello, Skillbox")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloSkillboxCompose2Theme {
        Greeting("Skillbox")
    }
}
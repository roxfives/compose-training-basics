package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content(names: List<String> = List(1000) { "Hello Android #$it" }) {
    val counterState = remember { mutableStateOf(0) }

    MyApp {
        Column(modifier = Modifier.fillMaxHeight()) {
            NameList(names = names, modifier = Modifier.weight(1f))

            Counter(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
            )
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = Color.Yellow,
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        if (isSelected) Color.Red else Color.Transparent
    )

    Surface(color = Color.Yellow, modifier = Modifier.fillMaxWidth()) {
        Text("Hello $name",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(24.dp)
                .background(color = backgroundColor)
                .clickable(onClick = { isSelected = !isSelected })
        )
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
//    Surface(color = Color.Yellow, modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { updateCount(count + 1)},
            Modifier.padding(start = 0.dp, top = 24.dp, bottom = 24.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 5) Color.Green else Color.White
            )
        ) {
            Text("I've been clicked $count times")
        }
//    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Content()
}
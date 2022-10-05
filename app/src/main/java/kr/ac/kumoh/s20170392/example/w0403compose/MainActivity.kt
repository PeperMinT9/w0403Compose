package kr.ac.kumoh.s20170392.example.w0403compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20170392.example.w0403compose.ui.theme.W0403ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Column() {
                    Counter()
                    Counter()
                    Counter()
                }

            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    W0403ComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)) {
        Text(text = "$count", fontSize = 150.sp)
        Row {
            Button(onClick = { count++ },
                modifier = Modifier.weight(1f)) {
                Text(text = "증가")
                Log.i("Count value: ", count.toString())
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = { count-- },
                modifier = Modifier.weight(1f)) {
                Text(text = "감소")
                Log.i("Count value: ", count.toString())
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    W0403ComposeTheme {
        MyApp {
            Counter()
        }
    }
}
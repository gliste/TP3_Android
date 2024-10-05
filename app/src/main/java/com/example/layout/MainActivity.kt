package com.example.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.layout.ui.theme.LayoutTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(modifier = Modifier
                        .padding(innerPadding)
                        .wrapContentSize(Alignment.Center))


                }
            }
        }
    }
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
fun GreetingPreview() {
    LayoutTheme {
        Greeting("Android")
    }

}

@Composable
fun Login(modifier: Modifier = Modifier){
    var username by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue())}
    var result by remember { mutableStateOf( "")}

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ){

        OutlinedTextField( //para los recuadros de username y pass
            value = username,
            onValueChange = { username = it},
            label = { Text ("Email") },
            modifier = Modifier //modifier se utiliza para embellecimiento
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

    OutlinedTextField(
        value = password,
        onValueChange = {password = it},
        label = {
            Text("Password")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        singleLine = true,
        visualTransformation = PasswordVisualTransformation()
    )

    Button(

        onClick = {
            if (username.text.isNotEmpty() && password.text.isNotEmpty()){
                result = "Login exitoso"
            }
            else {
                result = "Login no exitoso"
            }
        },
        modifier = Modifier
            .padding(10.dp)
            .align(Alignment.CenterHorizontally)
    )   {
        Text("Login")
    }

        Text (
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
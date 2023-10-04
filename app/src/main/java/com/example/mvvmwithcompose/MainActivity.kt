package com.example.mvvmwithcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmwithcompose.listener.RespostaServidor
import com.example.mvvmwithcompose.ui.theme.Purple40
import com.example.mvvmwithcompose.viewmodel.ViewModelMain
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: ViewModelMain = hiltViewModel()

            LayoutMVVM(viewModel)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LayoutMVVM(viewModel: ViewModelMain = hiltViewModel()) {

    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp, 10.dp, 25.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text(text = "Email")
                },
                textStyle = TextStyle(Purple40)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp, 10.dp, 25.dp),
                value = senha,
                onValueChange = {
                    senha = it
                },
                label = {
                    Text(text = "Senha")
                },
                textStyle = TextStyle(Purple40)
            )
            Button(onClick = {
                viewModel.login(email, senha, object : RespostaServidor{
                    override fun onSucess(mensagem: String) {
                        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(erro: String) {
                        Toast.makeText(context, erro, Toast.LENGTH_SHORT).show()
                    }

                })
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp, 10.dp, 25.dp)) {
                Text(text = "Salvar")
            }
        }

    }
}

@Preview
@Composable
fun LayoutMVVMPreview() {
    LayoutMVVM()
}

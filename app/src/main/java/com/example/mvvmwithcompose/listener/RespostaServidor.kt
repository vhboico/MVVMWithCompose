package com.example.mvvmwithcompose.listener

interface RespostaServidor {

    fun onSucess(mensagem: String)
    fun onFailure(erro: String)
}
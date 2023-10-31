package com.example.mvvmwithcompose.data

import com.example.mvvmwithcompose.listener.RespostaServidor
import javax.inject.Inject

class DataSource @Inject constructor(){
    fun login(email: String, senha: String, respostaServidor: RespostaServidor){

        if(email.isEmpty() || senha.isEmpty()){
            respostaServidor.onFailure("Preencha todos os campos")
        } else if(email == "admin@gmail.com" && senha == "123456"){
            respostaServidor.onSucess("Conta salva com sucesso")
        }else(
            respostaServidor.onFailure("Erro ao salvar dados")
        )
    }
}
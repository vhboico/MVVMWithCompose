package com.example.mvvmwithcompose.repository

import com.example.mvvmwithcompose.data.DataSource
import com.example.mvvmwithcompose.listener.RespostaServidor
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RepositorioMain @Inject constructor(private val dataSource: DataSource) {

    fun login(email: String, senha: String, respostaServidor: RespostaServidor){
        dataSource.login(email, senha, respostaServidor)
    }

}
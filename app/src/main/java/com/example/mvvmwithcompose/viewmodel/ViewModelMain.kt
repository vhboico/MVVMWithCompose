package com.example.mvvmwithcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmwithcompose.listener.RespostaServidor
import com.example.mvvmwithcompose.repository.RepositorioMain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMain @Inject constructor(private val repositorioMain: RepositorioMain): ViewModel() {

    fun login(email: String, senha: String, respostaServidor: RespostaServidor){
        repositorioMain.login(email, senha, respostaServidor)
    }
}
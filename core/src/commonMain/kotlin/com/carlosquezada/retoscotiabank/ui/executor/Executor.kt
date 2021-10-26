package com.carlosquezada.retoscotiabank.ui.executor

import kotlinx.coroutines.CoroutineDispatcher

/*
En cada plataforma hay un hilo para background
iOS - Android Funciona de otra manera para
¿Como hacemos una implementation especifica en android/iOS ?
 */
expect class Executor {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}
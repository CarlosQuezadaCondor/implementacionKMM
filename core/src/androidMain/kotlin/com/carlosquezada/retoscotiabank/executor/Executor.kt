package com.carlosquezada.retoscotiabank.ui.executor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/*
En cada plataforma hay un hilo para background
iOS - Android Funciona de otra manera para
¿Como hacemos una implementation especifica en android/iOS ?
 */
actual class Executor {
    actual val main: CoroutineDispatcher = Dispatchers.Main
    actual val io: CoroutineDispatcher = Dispatchers.Main
}
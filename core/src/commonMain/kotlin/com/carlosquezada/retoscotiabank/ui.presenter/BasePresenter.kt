package com.carlosquezada.retoscotiabank.presenter

import com.carlosquezada.retoscotiabank.domain.Either
import com.carlosquezada.retoscotiabank.domain.Result
import com.carlosquezada.retoscotiabank.ui.executor.Executor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

abstract class BasePresenter<out V : PresenterView>(val executor: Executor, val view: V) {

    private val job = SupervisorJob()

    protected val mainScope = CoroutineScope(job + executor.main)

    protected suspend fun <T> execute(block: suspend () -> Either<Result.Error, T>) =
        withContext(executor.io) { block() }

    abstract fun attach()

    fun detach() = job.cancel()
}

interface PresenterView {
    fun showProgress()
    fun hideProgress()

}


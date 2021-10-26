package com.carlosquezada.retoscotiabank.di

import com.carlosquezada.retoscotiabank.data.local.DbDriver
import com.carlosquezada.retoscotiabank.data.local.MoviesLocal
import com.carlosquezada.retoscotiabank.data.local.SqlDeligthLocal
import com.carlosquezada.retoscotiabank.data.remote.KtorRemote
import com.carlosquezada.retoscotiabank.data.remote.MoviesRemote
import org.koin.dsl.module

/*
val sourcesModules = module {
    single<MoviesRemote> { KtorRemote(get()) }
    single<MoviesLocal> { SqlDeligthLocal(DbDriver()) }
}
 */

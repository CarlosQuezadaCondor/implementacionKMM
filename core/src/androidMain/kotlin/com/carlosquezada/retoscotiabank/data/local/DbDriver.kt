package com.carlosquezada.retoscotiabank.data.local

import android.content.Context
import com.carlosquezada.core.movies
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DbDriver(private val context: Context) {
    actual fun get(): SqlDriver = AndroidSqliteDriver(
        schema = movies.Schema,
        context = context,
        name = "db"
    )

}
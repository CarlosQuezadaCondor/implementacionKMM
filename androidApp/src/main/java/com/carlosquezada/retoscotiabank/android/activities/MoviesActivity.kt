package com.carlosquezada.retoscotiabank.android.activities

import com.carlosquezada.retoscotiabank.android.R
import com.carlosquezada.retoscotiabank.android.base.BaseActivity
import com.carlosquezada.retoscotiabank.data.local.DbDriver
import com.carlosquezada.retoscotiabank.data.local.SqlDeligthLocal
import com.carlosquezada.retoscotiabank.data.remote.KtorRemote
import com.carlosquezada.retoscotiabank.data.repository.CommonMoviesRepository
import com.carlosquezada.retoscotiabank.domain.model.Movie
import com.carlosquezada.retoscotiabank.ui.executor.Executor
import com.carlosquezada.retoscotiabank.ui.presenter.MoviesPresenter
import com.carlosquezada.retoscotiabank.ui.presenter.MoviesView

class MoviesActivity : BaseActivity<MoviesView>(), MoviesView {

    override val basePresenter by lazy {
        MoviesPresenter(
            CommonMoviesRepository(
                moviesRemote = KtorRemote(),
                moviesLocal = SqlDeligthLocal(DbDriver(this))
            ),
            executor = Executor(),
            moviesView = this
        )
    }

    override val layoutId: Int = R.layout.activity_movies

    override fun initializeUI() {
        //Nothing to show
    }

    override fun registerListeners() {
        //Nothing to register
    }

    override fun showMovies(movies: List<Movie>) {
        print(movies)
    }


}
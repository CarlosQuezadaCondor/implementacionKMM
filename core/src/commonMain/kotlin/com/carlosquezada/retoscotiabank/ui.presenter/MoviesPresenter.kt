package com.carlosquezada.retoscotiabank.ui.presenter

import com.carlosquezada.retoscotiabank.data.repository.MoviesRepository
import com.carlosquezada.retoscotiabank.domain.model.Movie
import com.carlosquezada.retoscotiabank.presenter.BasePresenter
import com.carlosquezada.retoscotiabank.presenter.PresenterView
import com.carlosquezada.retoscotiabank.ui.executor.Executor
import kotlinx.coroutines.launch

class MoviesPresenter(
    private val moviesRepository: MoviesRepository,
    executor: Executor,
    moviesView: MoviesView
) :
    BasePresenter<MoviesView>(executor, moviesView) {

    override fun attach() {
        mainScope.launch {

            view.showProgress()

            execute { moviesRepository.getMovies() }.fold(
                error = {
                    print(it)
                        },
                success = {
                    view.showMovies(it)
                }
            )

            view.hideProgress()
        }
    }

    fun onMovieClick(movie: Movie) {
        print("$movie")
    }


}


interface MoviesView : PresenterView {
    fun showMovies(movies: List<Movie>)
}
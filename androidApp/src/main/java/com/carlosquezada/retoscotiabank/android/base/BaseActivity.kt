package com.carlosquezada.retoscotiabank.android.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.carlosquezada.retoscotiabank.android.R
import com.carlosquezada.retoscotiabank.presenter.BasePresenter
import com.carlosquezada.retoscotiabank.presenter.PresenterView

abstract class BaseActivity<out V : PresenterView> : AppCompatActivity(), PresenterView {


    abstract val basePresenter: BasePresenter<V>

    abstract val layoutId: Int

    private val progress: View by lazy { findViewById(R.id.layoutProgress) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
        initializeUI()
        registerListeners()
        basePresenter.attach()

    }

    override fun onDestroy() {
        super.onDestroy()
        basePresenter.detach()
    }

    abstract fun initializeUI()

    abstract fun registerListeners()

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }


}
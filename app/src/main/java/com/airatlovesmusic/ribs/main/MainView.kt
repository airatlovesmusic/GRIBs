package com.airatlovesmusic.ribs.main

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.main_rib.view.*

class MainView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle), MainInteractor.MainPresenter {

    override fun showSecondScreen(): Observable<Unit> =
        btn_go_to_second.clicks()

    override fun showSnack(): Observable<String> =
        btn_snack.clicks().map { "Hello from ${this@MainView.javaClass.simpleName}" }

}

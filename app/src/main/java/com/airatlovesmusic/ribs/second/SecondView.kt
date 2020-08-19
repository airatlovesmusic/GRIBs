package com.airatlovesmusic.ribs.second

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.second_rib.view.*

class SecondView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle), SecondInteractor.SecondPresenter {

    override fun showFirstView(): Observable<Unit> =
        btn_go_to_first.clicks()

    override fun showSnack(): Observable<String> =
        btn_snack.clicks().map { "Hello from ${this@SecondView.javaClass.simpleName}" }

}

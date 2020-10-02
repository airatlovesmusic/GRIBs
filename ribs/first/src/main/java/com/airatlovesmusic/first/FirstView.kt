package com.airatlovesmusic.first

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.first_rib.view.*

class FirstView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle), FirstInteractor.MainPresenter {

    override fun showSecondScreen(): Observable<Unit> =
        btn_go_to_second.clicks()

    override fun showSnack(): Observable<String> =
        btn_snack.clicks().map { "Hello from ${this@FirstView.javaClass.simpleName}" }

}

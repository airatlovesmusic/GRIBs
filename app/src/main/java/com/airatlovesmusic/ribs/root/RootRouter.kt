package com.airatlovesmusic.ribs.root

import com.airatlovesmusic.ribs.first.FirstBuilder
import com.airatlovesmusic.ribs.first.FirstRouter
import com.airatlovesmusic.ribs.second.SecondBuilder
import com.airatlovesmusic.ribs.second.SecondRouter
import com.uber.rib.core.ViewRouter

class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val mainBuilder: FirstBuilder,
    private val secondBuilder: SecondBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {

    private var mainRouter: FirstRouter? = null
    private var secondRouter: SecondRouter? = null

    fun attachMainView() {
        mainRouter = mainBuilder.build(view)
        attachChild(mainRouter)
        view.addView(mainRouter!!.view)
    }

    fun detachMainView() {
        if (mainRouter != null) {
            detachChild(mainRouter)
            view.removeView(mainRouter!!.view)
            mainRouter = null
        }
    }

    fun attachSecondView() {
        secondRouter = secondBuilder.build(view)
        attachChild(secondRouter)
        view.addView(secondRouter!!.view)
    }

    fun detachSecondView() {
        if (secondRouter != null) {
            detachChild(secondRouter)
            view.removeView(secondRouter!!.view)
            secondRouter = null
        }
    }

}
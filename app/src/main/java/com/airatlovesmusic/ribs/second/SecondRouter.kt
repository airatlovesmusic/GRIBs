package com.airatlovesmusic.ribs.second

import android.view.View

import com.uber.rib.core.ViewRouter

class SecondRouter(
    view: SecondView,
    interactor: SecondInteractor,
    component: SecondBuilder.Component
) : ViewRouter<SecondView, SecondInteractor, SecondBuilder.Component>(view, interactor, component)

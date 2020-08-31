package com.airatlovesmusic.ribs.first

import com.uber.rib.core.ViewRouter

class FirstRouter(
    view: FirstView,
    interactor: FirstInteractor,
    component: FirstBuilder.Component
) : ViewRouter<FirstView, FirstInteractor, FirstBuilder.Component>(view, interactor, component)

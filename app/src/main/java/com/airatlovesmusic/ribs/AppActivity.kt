package com.airatlovesmusic.ribs

import android.os.Bundle
import android.view.ViewGroup
import com.airatlovesmusic.global.system.logger.Logger
import com.airatlovesmusic.root.RootBuilder
import com.airatlovesmusic.root.RootInteractor
import com.google.android.material.snackbar.Snackbar
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter
import javax.inject.Inject

class AppActivity: RibActivity() {

    @Inject lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
        val builder = RootBuilder(object :
            RootBuilder.ParentComponent {
            override fun listener(): RootInteractor.RootListener =
                object : RootInteractor.RootListener {
                    override fun showSnack(message: String) {
                        Snackbar.make(parentViewGroup.rootView, message, Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }

            override fun logger() = logger
        })
        return builder.build(parentViewGroup)
    }

}
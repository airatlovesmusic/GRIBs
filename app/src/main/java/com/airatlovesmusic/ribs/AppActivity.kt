package com.airatlovesmusic.ribs

import android.view.ViewGroup
import android.widget.Toast
import com.airatlovesmusic.ribs.root.RootBuilder
import com.airatlovesmusic.ribs.root.RootInteractor
import com.google.android.material.snackbar.Snackbar
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class AppActivity: RibActivity() {

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
        val builder = RootBuilder(object : RootBuilder.ParentComponent {
            override fun listener(): RootInteractor.RootListener = object: RootInteractor.RootListener {
                override fun showSnack(message: String) {
                    Snackbar.make(parentViewGroup.rootView, message, Snackbar.LENGTH_SHORT).show()
                }
            }
        })
        return builder.build(parentViewGroup)
    }

}
package com.airatlovesmusic.ribs.root

import com.airatlovesmusic.ribs.main.MainInteractor
import com.airatlovesmusic.ribs.second.SecondInteractor
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

@RibInteractor
class RootInteractor : Interactor<RootInteractor.RootPresenter, RootRouter>() {

  @Inject
  lateinit var presenter: RootPresenter
  @Inject
  lateinit var listener: RootListener

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    router.attachMainView()
  }

  inner class MainListener: MainInteractor.Listener {
    override fun goToSecondScreen() {
      router.detachMainView()
      router.attachSecondView()
    }

    override fun showSnack(message: String) {
      listener.showSnack(message)
    }
  }

  inner class SecondListener: SecondInteractor.Listener {
    override fun goToFirstView() {
      router.detachSecondView()
      router.attachMainView()
    }
    override fun showSnack(message: String) {
      listener.showSnack(message)
    }
  }

  interface RootListener {
    fun showSnack(message: String)
  }

  interface RootPresenter
}

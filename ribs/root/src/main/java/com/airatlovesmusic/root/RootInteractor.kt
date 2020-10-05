package com.airatlovesmusic.root

import com.airatlovesmusic.first.FirstInteractor
import com.airatlovesmusic.global.system.logger.Logger
import com.airatlovesmusic.second.SecondInteractor
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
  @Inject
  lateinit var logger: Logger

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    router.attachMainView()
  }

  inner class MainListener: FirstInteractor.Listener {
    override fun goToSecondScreen() {
      router.detachMainView()
      router.attachSecondView()
    }

    override fun showSnack(message: String) {
      listener.showSnack(message)
    }

    override fun logMessage(message: String) {
      logger.logMessage(message)
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

    override fun logMessage(message: String) {
      logger.logMessage(message)
    }
  }

  interface RootListener {
    fun showSnack(message: String)
  }

  interface RootPresenter
}

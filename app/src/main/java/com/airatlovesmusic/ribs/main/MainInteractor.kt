package com.airatlovesmusic.ribs.main

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@RibInteractor
class MainInteractor : Interactor<MainInteractor.MainPresenter, MainRouter>() {

  @Inject
  lateinit var presenter: MainPresenter
  @Inject
  lateinit var listener: Listener

  private val disposables = CompositeDisposable()

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    presenter.showSecondScreen()
      .subscribe { listener.goToSecondScreen() }
      .apply { disposables.add(this) }
    presenter.showSnack()
      .subscribe {
        listener.showSnack(it)
        listener.logMessage(it)
      }
      .apply { disposables.add(this) }
  }

  override fun willResignActive() {
    super.willResignActive()
    disposables.dispose()
  }

  interface Listener {
    fun goToSecondScreen()
    fun showSnack(message: String)
    fun logMessage(message: String)
  }

  interface MainPresenter {
    fun showSecondScreen(): Observable<Unit>
    fun showSnack(): Observable<String>
  }
}

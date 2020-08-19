package com.airatlovesmusic.ribs.second

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@RibInteractor
class SecondInteractor : Interactor<SecondInteractor.SecondPresenter, SecondRouter>() {

  @Inject
  lateinit var presenter: SecondPresenter
  @Inject
  lateinit var listener: Listener

  private val disposables = CompositeDisposable()

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    presenter.showFirstView()
      .subscribe { listener.goToFirstView() }
      .apply { disposables.add(this) }
    presenter.showSnack()
      .subscribe { listener.showSnack(it) }
      .apply { disposables.add(this) }
  }

  override fun willResignActive() {
    super.willResignActive()
    disposables.dispose()
  }

  interface Listener {
    fun goToFirstView()
    fun showSnack(message: String)
  }

  interface SecondPresenter {
    fun showFirstView(): Observable<Unit>
    fun showSnack(): Observable<String>
  }
}

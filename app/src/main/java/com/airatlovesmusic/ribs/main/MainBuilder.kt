package com.airatlovesmusic.ribs.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.airatlovesmusic.ribs.R
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

class MainBuilder(dependency: ParentComponent) : ViewBuilder<MainView, MainRouter, MainBuilder.ParentComponent>(dependency) {

  fun build(parentViewGroup: ViewGroup): MainRouter {
    val view = createView(parentViewGroup)
    val interactor = MainInteractor()
    val component = DaggerMainBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.mainRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): MainView? {
    return inflater.inflate(R.layout.main_rib, parentViewGroup, false) as MainView?
  }

  interface ParentComponent {
    fun mainListener(): MainInteractor.Listener
  }

  @dagger.Module
  abstract class Module {

    @MainScope
    @Binds
    internal abstract fun presenter(view: MainView): MainInteractor.MainPresenter

    @dagger.Module
    companion object {

      @MainScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: MainView,
          interactor: MainInteractor
      ): MainRouter {
        return MainRouter(view, interactor, component)
      }
    }

  }

  @MainScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<MainInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: MainInteractor): Builder

      @BindsInstance
      fun view(view: MainView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun mainRouter(): MainRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class MainScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class MainInternal
}

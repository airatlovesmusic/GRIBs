package com.airatlovesmusic.ribs.first

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

class FirstBuilder(dependency: ParentComponent) : ViewBuilder<FirstView, FirstRouter, FirstBuilder.ParentComponent>(dependency) {

  fun build(parentViewGroup: ViewGroup): FirstRouter {
    val view = createView(parentViewGroup)
    val interactor = FirstInteractor()
    val component = DaggerMainBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.mainRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): FirstView? {
    return inflater.inflate(R.layout.first_rib, parentViewGroup, false) as FirstView?
  }

  interface ParentComponent {
    fun mainListener(): FirstInteractor.Listener
  }

  @dagger.Module
  abstract class Module {

    @MainScope
    @Binds
    internal abstract fun presenter(view: FirstView): FirstInteractor.MainPresenter

    @dagger.Module
    companion object {

      @MainScope
      @Provides
      @JvmStatic
      internal fun router(
        component: Component,
        view: FirstView,
        interactor: FirstInteractor
      ): FirstRouter {
        return FirstRouter(view, interactor, component)
      }
    }

  }

  @MainScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<FirstInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: FirstInteractor): Builder

      @BindsInstance
      fun view(view: FirstView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun mainRouter(): FirstRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class MainScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class MainInternal
}

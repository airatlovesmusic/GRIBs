package com.airatlovesmusic.second

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

class SecondBuilder(dependency: ParentComponent) : ViewBuilder<SecondView, SecondRouter, SecondBuilder.ParentComponent>(dependency) {

  fun build(parentViewGroup: ViewGroup): SecondRouter {
    val view = createView(parentViewGroup)
    val interactor = SecondInteractor()
    val component = DaggerSecondBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.secondRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): SecondView? {
    return inflater.inflate(R.layout.second_rib, parentViewGroup, false) as SecondView?
  }

  interface ParentComponent {
    fun secondListener(): SecondInteractor.Listener
  }

  @dagger.Module
  abstract class Module {

    @SecondScope
    @Binds
    internal abstract fun presenter(view: SecondView): SecondInteractor.SecondPresenter

    @dagger.Module
    companion object {

      @SecondScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: SecondView,
          interactor: SecondInteractor
      ): SecondRouter {
        return SecondRouter(view, interactor, component)
      }
    }
  }

  @SecondScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<SecondInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: SecondInteractor): Builder

      @BindsInstance
      fun view(view: SecondView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun secondRouter(): SecondRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class SecondScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class SecondInternal
}

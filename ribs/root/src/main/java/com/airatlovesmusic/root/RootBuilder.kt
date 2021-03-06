package com.airatlovesmusic.root

import android.view.LayoutInflater
import android.view.ViewGroup
import com.airatlovesmusic.first.FirstBuilder
import com.airatlovesmusic.first.FirstInteractor
import com.airatlovesmusic.global.system.logger.Logger
import com.airatlovesmusic.second.SecondBuilder
import com.airatlovesmusic.second.SecondInteractor
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

class RootBuilder(dependency: ParentComponent) :
  ViewBuilder<RootView, RootRouter, RootBuilder.ParentComponent>(dependency) {

  fun build(parentViewGroup: ViewGroup): RootRouter {
    val view = createView(parentViewGroup)
    val interactor = RootInteractor()
    val component = DaggerRootBuilder_Component.builder()
      .parentComponent(dependency)
      .view(view)
      .interactor(interactor)
      .build()
    return component.rootRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): RootView? {
    return inflater.inflate(R.layout.root_rib, parentViewGroup, false) as RootView?
  }

  interface ParentComponent {
    fun listener(): RootInteractor.RootListener
    fun logger(): Logger
  }

  @dagger.Module
  abstract class Module {

    @RootScope
    @Binds
    internal abstract fun presenter(view: RootView): RootInteractor.RootPresenter

    companion object {
      @RootScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: RootView,
          interactor: RootInteractor
      ): RootRouter {
        return RootRouter(view, interactor, component, FirstBuilder(component), SecondBuilder(component))
      }

      @RootScope
      @Provides
      @JvmStatic
      fun mainListener(rootInteractor: RootInteractor): FirstInteractor.Listener {
        return rootInteractor.MainListener()
      }

      @RootScope
      @Provides
      @JvmStatic
      fun secondListener(rootInteractor: RootInteractor): SecondInteractor.Listener {
        return rootInteractor.SecondListener()
      }
    }

  }

  @RootScope
  @dagger.Component(
    modules = [Module::class],
    dependencies = [ParentComponent::class]
  )
  interface Component: InteractorBaseComponent<RootInteractor>, BuilderComponent, FirstBuilder.ParentComponent, SecondBuilder.ParentComponent {

    @dagger.Component.Builder
    interface Builder {

      @BindsInstance
      fun interactor(interactor: RootInteractor): Builder

      @BindsInstance
      fun view(view: RootView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun rootRouter(): RootRouter
  }

  @Scope
  @kotlin.annotation.Retention(AnnotationRetention.BINARY)
  internal annotation class RootScope

  @Qualifier
  @kotlin.annotation.Retention(AnnotationRetention.BINARY)
  internal annotation class RootInternal
}
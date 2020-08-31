package com.airatlovesmusic.ribs.root

import com.airatlovesmusic.ribs.first.FirstBuilder
import com.airatlovesmusic.ribs.second.SecondBuilder
import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RootRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: RootBuilder.Component
  @Mock internal lateinit var interactor: RootInteractor
  @Mock internal lateinit var view: RootView
  @Mock internal lateinit var firstBuilder: FirstBuilder
  @Mock internal lateinit var secondBuilder: SecondBuilder

  private var router: RootRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = RootRouter(view, interactor, component, firstBuilder, secondBuilder)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}


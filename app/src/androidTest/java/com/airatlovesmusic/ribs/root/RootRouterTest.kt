package com.airatlovesmusic.ribs.root

import com.airatlovesmusic.first.FirstBuilder
import com.airatlovesmusic.second.SecondBuilder
import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RootRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: com.airatlovesmusic.root.RootBuilder.Component
  @Mock internal lateinit var interactor: com.airatlovesmusic.root.RootInteractor
  @Mock internal lateinit var view: com.airatlovesmusic.root.RootView
  @Mock internal lateinit var firstBuilder: com.airatlovesmusic.first.FirstBuilder
  @Mock internal lateinit var secondBuilder: com.airatlovesmusic.second.SecondBuilder

  private var router: com.airatlovesmusic.root.RootRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = com.airatlovesmusic.root.RootRouter(
        view,
        interactor,
        component,
        firstBuilder,
        secondBuilder
    )
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


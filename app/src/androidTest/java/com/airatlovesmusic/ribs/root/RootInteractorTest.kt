package com.airatlovesmusic.ribs.root

import com.airatlovesmusic.ribs.data.Logger
import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RootInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: com.airatlovesmusic.root.RootInteractor.RootPresenter
  @Mock internal lateinit var router: com.airatlovesmusic.root.RootRouter
  @Mock internal lateinit var logger: Logger
  @Mock internal lateinit var listener: com.airatlovesmusic.root.RootInteractor.RootListener

  private var interactor: com.airatlovesmusic.root.RootInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestRootInteractor.create(presenter, listener, logger)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<com.airatlovesmusic.root.RootInteractor.RootPresenter, com.airatlovesmusic.root.RootRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
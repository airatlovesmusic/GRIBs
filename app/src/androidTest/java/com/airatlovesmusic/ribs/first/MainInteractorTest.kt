package com.airatlovesmusic.ribs.first

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: com.airatlovesmusic.first.FirstInteractor.MainPresenter
  @Mock internal lateinit var router: com.airatlovesmusic.first.FirstRouter
  @Mock internal lateinit var listener: com.airatlovesmusic.first.FirstInteractor.Listener

  private var interactor: com.airatlovesmusic.first.FirstInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
    interactor = TestMainInteractor.create(presenter, listener)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<com.airatlovesmusic.first.FirstInteractor.MainPresenter, com.airatlovesmusic.first.FirstRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
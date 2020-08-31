package com.airatlovesmusic.ribs.first

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: FirstInteractor.MainPresenter
  @Mock internal lateinit var router: FirstRouter
  @Mock internal lateinit var listener: FirstInteractor.Listener

  private var interactor: FirstInteractor? = null

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
    InteractorHelper.attach<FirstInteractor.MainPresenter, FirstRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
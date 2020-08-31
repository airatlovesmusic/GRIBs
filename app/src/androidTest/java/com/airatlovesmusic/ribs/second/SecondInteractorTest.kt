package com.airatlovesmusic.ribs.second

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SecondInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: SecondInteractor.SecondPresenter
  @Mock internal lateinit var router: SecondRouter
  @Mock internal lateinit var listener: SecondInteractor.Listener

  private var interactor: SecondInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestSecondInteractor.create(presenter, listener)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<SecondInteractor.SecondPresenter, SecondRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
package com.airatlovesmusic.ribs.second

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SecondInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: com.airatlovesmusic.second.SecondInteractor.SecondPresenter
  @Mock internal lateinit var router: com.airatlovesmusic.second.SecondRouter
  @Mock internal lateinit var listener: com.airatlovesmusic.second.SecondInteractor.Listener

  private var interactor: com.airatlovesmusic.second.SecondInteractor? = null

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
    InteractorHelper.attach<com.airatlovesmusic.second.SecondInteractor.SecondPresenter, com.airatlovesmusic.second.SecondRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}
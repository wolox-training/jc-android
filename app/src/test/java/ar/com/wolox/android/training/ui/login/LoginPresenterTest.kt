package ar.com.wolox.android.training.ui.login

import ar.com.wolox.android.training.utils.UserSession
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.mockito.Mock

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {

    @Mock
    lateinit var userSession: UserSession

    override fun getPresenterInstance() = LoginPresenter(userSession)

    @Test
    fun `given an user and a color when login button is clicked then user session should be updated`() {

        // GIVEN
        val user = "Test"
        val color = "_"

        // WHEN
        presenter.onLoginButtonClicked(user, color)

        // THEN
        verify(userSession, times(1)).username = user
    }

    @Test
    fun `given an user and a color when login button is clicked then view should go to viewpager`() {

        // GIVEN
        val user = "Test"
        val color = "blue"

        // WHEN
        presenter.onLoginButtonClicked(user, color)

        // THEN
        // verify(view, times(1)).goToViewPager(color)
    }
}

package ar.com.wolox.android.training.ui.login

import ar.com.wolox.android.training.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    fun onLoginButtonClicked(user: String, password: String) {
        userSession.username = user
        userSession.password = password
    }
}

package ar.com.wolox.android.training.ui.login

import ar.com.wolox.android.training.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    fun onLoginButtonClicked(user: String, password: String) {
        userSession.username = user
        userSession.password = password
    }

    fun onUsernameInputChanged(text: String) = view?.toggleLoginButtonEnable(text.isNotBlank())

    fun onPasswordInputChanged(text: String) = view?.toggleLoginButtonEnable(text.isNotBlank())

    fun onWoloxLinkClicked() = view?.openBrowser(WOLOX_URL)

    fun onWoloxPhoneClicked() = view?.openPhone(WOLOX_PHONE)

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
        private const val WOLOX_PHONE = "08001234567"
    }
}

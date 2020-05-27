package ar.com.wolox.android.training.ui.login

interface LoginView {

    fun openBrowser(url: String)

    fun toggleLoginButtonEnable(isEnable: Boolean)

    fun openPhone(woloxPhone: String): Any
}

package ar.com.wolox.android.training.ui.login

import androidx.core.widget.addTextChangedListener
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.openBrowser
import ar.com.wolox.wolmo.core.util.openDial
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment private constructor() : WolmoFragment<LoginPresenter>(), LoginView {

    override fun layout() = R.layout.fragment_login

    override fun init() {
    }

    override fun setListeners() {
        vUsernameInput.addTextChangedListener { presenter.onUsernameInputChanged(it.toString()) }
        vPasswordInput.addTextChangedListener { presenter.onPasswordInputChanged(it.toString()) }
        vWoloxLink.setOnClickListener { presenter.onWoloxLinkClicked() }
        vWoloxPhone.setOnClickListener { presenter.onWoloxPhoneClicked() }
        vLoginButton.setOnClickListener {
            presenter.onLoginButtonClicked(vUsernameInput.text.toString(), vPasswordInput.text.toString())
        }
    }

    override fun toggleLoginButtonEnable(isEnable: Boolean) {
        vLoginButton.isEnabled = isEnable
    }

    override fun openBrowser(url: String) = requireContext().openBrowser(url)

    override fun openPhone(woloxPhone: String) = requireContext().openDial(woloxPhone)

    companion object {
        fun newInstance() = LoginFragment()
    }
}

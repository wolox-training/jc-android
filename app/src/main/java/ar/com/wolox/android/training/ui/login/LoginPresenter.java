package ar.com.wolox.android.training.ui.login;

import javax.inject.Inject;

import ar.com.wolox.android.training.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/** My <b>LoginPresenter</b>. */
public class LoginPresenter extends BasePresenter<LoginView> {

    private final UserSession userSession;

    @Inject
    public LoginPresenter(final UserSession userSession) {
        this.userSession = userSession;
    }

    public void onLoginButtonClicked() {
        // do something in nexts cards
    }

    public void onSignupClicked() {
        // do something in nexts cards
    }

    public void onTermsAndConditionsClicked() {
        // do something in nexts cards
    }
}

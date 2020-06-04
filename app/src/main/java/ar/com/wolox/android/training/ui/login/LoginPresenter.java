package ar.com.wolox.android.training.ui.login;

import java.util.Objects;

import javax.inject.Inject;

import ar.com.wolox.android.training.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/** My <b>LoginPresenter</b>. */
public class LoginPresenter extends BasePresenter<ILoginView> {

    private final UserSession userSession;
    private static final String URL = "http://www.wolox.com.ar";

    @Inject
    public LoginPresenter(final UserSession userSession) {
        this.userSession = userSession;
    }

    public void onLoginButtonClicked() {
        Objects.requireNonNull(this.getView()).showHomeScreen();
    }

    public void onSignupClicked() {
        Objects.requireNonNull(this.getView()).showSignUpScreen();
    }

    public void onTermsAndConditionsClicked() {
        Objects.requireNonNull(this.getView()).goToLink(URL);
    }
}

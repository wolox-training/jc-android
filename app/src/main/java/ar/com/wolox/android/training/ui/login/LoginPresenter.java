package ar.com.wolox.android.training.ui.login;

import android.util.Patterns;

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

    /**
     * My <b>LoginPresenter</b>.
     * The validation of user credentials. If they are correct, redirect to HomeScreen and save email,
     *
     * @param email    User email (cannot be empty and have to respect email pattern)
     * @param password User password (cannot be empty)
     */

    public void onLoginButtonClicked(final String email, final String password) {
        if (isEmailValid(email) && isPasswordValid(password)) {
            userSession.setUsername(email);
            Objects.requireNonNull(this.getView()).showHomeScreen();
        }
    }

    public void onSignUpClicked() {
        Objects.requireNonNull(this.getView()).showSignUpScreen();
    }

    public void onTermsAndConditionsClicked() {
        Objects.requireNonNull(this.getView()).goToLink(URL);
    }

    private Boolean isEmailValid(final String email) {
        Boolean isValid = Boolean.TRUE;
        if (email.isEmpty()) {
            this.getView().invalidEmptyEmail();
            isValid = Boolean.FALSE;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            this.getView().invalidFormatEmail();
            isValid = Boolean.FALSE;
        }
        return isValid;
    }

    private Boolean isPasswordValid(final String password) {
        Boolean isValid = Boolean.TRUE;
        if (password.isEmpty()) {
            this.getView().invalidEmptyPassword();
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}
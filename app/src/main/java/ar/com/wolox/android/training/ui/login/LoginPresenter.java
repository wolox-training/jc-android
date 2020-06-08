package ar.com.wolox.android.training.ui.login;

import android.util.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import ar.com.wolox.android.training.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * My <b>LoginPresenter</b>.
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    private final UserSession userSession;
    private static final String URL = "http://www.wolox.com.ar";

    @Inject
    public LoginPresenter(final UserSession userSession) {
        this.userSession = userSession;
    }

    /**
     * My <b>onLoginButtonClicked method</b>.
     * The validation of user credentials. If they are correct, redirect to HomeScreen and save email,
     *
     * @param email    User email (cannot be empty and have to respect email pattern)
     * @param password User password (cannot be empty)
     */

    public void onLoginButtonClicked(final String email, final String password) {
        final List<LoginErrors> errors = getErrors(email, password);
        if (errors.isEmpty()) {
            userSession.setUsername(email);
            Objects.requireNonNull(this.getView()).showHomeScreen();
        } else {
            showErrors(errors);
        }
    }

    public void onSignUpClicked() {
        Objects.requireNonNull(this.getView()).showSignUpScreen();
    }

    public void onTermsAndConditionsClicked() {
        Objects.requireNonNull(this.getView()).goToLink(URL);
    }

    private List<LoginErrors> getErrors(final String email, final String password) {
        List<LoginErrors> errors = new ArrayList<>();
        final boolean isEmailInvalidFormat = !Patterns.EMAIL_ADDRESS.matcher(email).matches();
        final boolean isEmailEmpty = email.isEmpty();
        final boolean isPasswordEmpty = password.isEmpty();

        if (isEmailEmpty) {
            errors.add(LoginErrors.EMPTY_EMAIL);
        } else if (isEmailInvalidFormat) {
            errors.add(LoginErrors.INVALID_FORMAT_EMAIL);
        }
        if (isPasswordEmpty) {
            errors.add(LoginErrors.EMPTY_PASSWORD);
        }

        return errors;
    }

    private void showErrors(final List<LoginErrors> errors) {
        for (LoginErrors error : errors) {
            error.showError(this.getView());
        }
    }

    private enum LoginErrors {

        INVALID_FORMAT_EMAIL {
            public void showError(final ILoginView view) {
                view.invalidFormatEmail();
            }
        },
        EMPTY_EMAIL {
            public void showError(final ILoginView view) {
                view.invalidEmptyEmail();
            }
        },
        EMPTY_PASSWORD {
            public void showError(final ILoginView view) {
                view.invalidEmptyPassword();
            }
        };

        public abstract void showError(ILoginView view);
    }
}

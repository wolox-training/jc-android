package ar.com.wolox.android.training.ui.login;

import android.util.Patterns;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;

import ar.com.wolox.android.training.model.User;
import ar.com.wolox.android.training.network.services.IUserService;
import ar.com.wolox.android.training.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * My <b>LoginPresenter</b>.
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    private final UserSession userSession;
    private final RetrofitServices retrofitServices;
    private static final String URL = "http://www.wolox.com.ar";

    @Inject
    public LoginPresenter(final UserSession userSession, final RetrofitServices retrofitServices) {
        this.userSession = userSession;
        this.retrofitServices = retrofitServices;
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
            authenticateUser(email, password);
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

    private Callback<List<User>> doLogin(String email) {
        getView().showLoading();
        return new Callback<List<User>>() {

            @Override
            public void onResponse(@NonNull final Call<List<User>> call, @NonNull final Response<List<User>> response) {
                final List<User> users = response.body();
                final boolean isValidUser = users != null && !users.isEmpty() && users.get(0) != null;
                if (isValidUser) {
                    userSession.setUsername(email);
                    userSession.setUserId(response.body().get(0).getId());
                    getView().showHomeScreen();
                }
                getView().stopLoading();
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                getView().invalidUserCredentials();
                getView().stopLoading();
            }
        };
    }

    private void authenticateUser(final String email, final String password) {
        IUserService userService = retrofitServices.getService(IUserService.class);
        Map<String, String> userData = new HashMap<>();
        userData.put("email", email);
        userData.put("password", password);
        userService.findUserByEmailAndPassword(userData).enqueue(doLogin(email));
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

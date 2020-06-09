package ar.com.wolox.android.training.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>LoginFragment</b>. */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {

    private TextView termsConditions;
    private TextView logInButton;
    private TextView signUpButton;
    private TextView userEmail;
    private TextView userPassword;
    private ProgressBar loadingProgressBar;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void init() {
        termsConditions = getView().findViewById(R.id.vTermsConditions);
        logInButton = getView().findViewById(R.id.vLogInButton);
        signUpButton = getView().findViewById(R.id.vSignUpButton);
        userEmail = getView().findViewById(R.id.vLogInEmail);
        userPassword = getView().findViewById(R.id.vLogInPassword);
        loadingProgressBar = getView().findViewById(R.id.vLoadingProgressBar);
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        termsConditions.setOnClickListener(it -> getPresenter().onTermsAndConditionsClicked());
        logInButton.setOnClickListener(it -> getPresenter()
                .onLoginButtonClicked(userEmail.getText().toString(), userPassword.getText().toString()));
        signUpButton.setOnClickListener(it -> getPresenter().onSignUpClicked());
    }

    @Override
    public void showSignUpScreen() {
        SignUpActivity.start(this.getContext());
    }

    @Override
    public void showHomeScreen() {
        HomeActivity.start(this.getContext());
    }

    @Override
    public void goToLink(final String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void invalidFormatEmail() {
        userEmail.setError(getString(R.string.login_error_invalid_format_email));
    }

    @Override
    public void invalidEmptyEmail() {
        userEmail.setError(getString(R.string.login_error_invalid_empty_email));
    }

    @Override
    public void invalidEmptyPassword() {
        userPassword.setError(getString(R.string.login_error_invalid_empty_password));
    }

    @Override
    public void invalidUserCredentials() {
        Toast.makeText(requireContext(), R.string.login_error_invalid_user_credentials, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        loadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        loadingProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void failConnection() {
        Toast.makeText(requireContext(), R.string.login_error_fail_connection, Toast.LENGTH_SHORT).show();
    }
}

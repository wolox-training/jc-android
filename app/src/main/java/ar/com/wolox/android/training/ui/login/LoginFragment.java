package ar.com.wolox.android.training.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;
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
}

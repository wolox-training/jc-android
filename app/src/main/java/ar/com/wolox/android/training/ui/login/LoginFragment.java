package ar.com.wolox.android.training.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>LoginFragment</b>. */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {

    private static final String ARG_CAUGHT = "loginFragment_caught";
    private TextView termsConditions;
    private TextView logInButton;
    private TextView signUpButton;

    public static LoginFragment newInstance(final String caught) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CAUGHT, caught);
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setArguments(args);
        return loginFragment;
    }

    @Override
    public void init() {
        termsConditions = getView().findViewById(R.id.vTermsConditions);
        logInButton = getView().findViewById(R.id.vLogInButton);
        signUpButton = getView().findViewById(R.id.vSignUpButton);
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        termsConditions.setOnClickListener(it -> getPresenter().onTermsAndConditionsClicked());
        logInButton.setOnClickListener(it -> getPresenter().onLoginButtonClicked());
        signUpButton.setOnClickListener(it -> getPresenter().onSignupClicked());
    }

    @Override
    public void showSignUpScreen() {
        final Intent intent = new Intent(getActivity(), SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showHomeScreen() {
        final Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToLink(final String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}

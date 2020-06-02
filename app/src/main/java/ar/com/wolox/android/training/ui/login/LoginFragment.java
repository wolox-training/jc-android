package ar.com.wolox.android.training.ui.login;

import android.content.Intent;
import android.net.Uri;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>LoginFragment</b>. */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {

    private static LoginFragment instance;

    public static LoginFragment newInstance() {
        if (instance == null) {
            instance = new LoginFragment();
        }
        return instance;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        getView().findViewById(R.id.vTermsConditions)
                .setOnClickListener(it -> getPresenter().onTermsAndConditionsClicked());
        getView().findViewById(R.id.vLogInButton)
                .setOnClickListener(it -> getPresenter().onLoginButtonClicked());
        getView().findViewById(R.id.vSignUpButton)
                .setOnClickListener(it -> getPresenter().onSignupClicked());
    }

    @Override
    public void getSignUpView() {
        final Intent intent = new Intent(getActivity(), SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void getHomeView() {
        final Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void openTermsAndConditionsUrl(final String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}

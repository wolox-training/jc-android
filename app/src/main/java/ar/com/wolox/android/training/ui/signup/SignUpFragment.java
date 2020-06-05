package ar.com.wolox.android.training.ui.signup;

import android.os.Bundle;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>SignUpFragment</b>. */
public class SignUpFragment extends WolmoFragment<SignUpPresenter> implements ISignUpView {

    private static final String ARG_CAUGHT = "signUpFragment_caught";

    public static SignUpFragment newInstance(final String caught) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CAUGHT, caught);
        SignUpFragment signUpFragment = new SignUpFragment();
        signUpFragment.setArguments(args);
        return signUpFragment;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_sign_up;
    }
}

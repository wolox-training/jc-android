package ar.com.wolox.android.training.ui.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>SignUpFragment</b>. */
public class SignUpFragment extends WolmoFragment<SignUpPresenter> implements ISignUpView {

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_sign_up;
    }
}

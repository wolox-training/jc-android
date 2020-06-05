package ar.com.wolox.android.training.ui.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/** My <b>SignUpActivity</b>. */
public class SignUpActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_sign_up;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivitySignUp, SignUpFragment.newInstance("signUpActivity"));
    }
}

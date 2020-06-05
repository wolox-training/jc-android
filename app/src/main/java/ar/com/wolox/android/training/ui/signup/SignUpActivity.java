package ar.com.wolox.android.training.ui.signup;

import android.content.Context;
import android.content.Intent;

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
        replaceFragment(R.id.vActivitySignUp, SignUpFragment.newInstance());
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SignUpActivity.class);
        context.startActivity(starter);
    }
}

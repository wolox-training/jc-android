package ar.com.wolox.android.training.ui.login;

import android.content.Context;
import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/** My <b>LoginActivity</b>. */
public class LoginActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivityLogin, LoginFragment.newInstance());
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }
}

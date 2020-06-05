package ar.com.wolox.android.training.ui.home;

import android.content.Context;
import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * My <b>HomeActivity</b>.
 */
public class HomeActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_home;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivityHome, HomeFragment.newInstance());
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeActivity.class);
        context.startActivity(starter);
    }
}

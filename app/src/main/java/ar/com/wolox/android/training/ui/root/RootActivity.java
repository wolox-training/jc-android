package ar.com.wolox.android.training.ui.root;

import android.content.Context;
import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * My <b>RootActivity</b>.
 */
public class RootActivity extends WolmoActivity {

    @Override
    public int layout() {
        return R.layout.activity_root;
    }

    @Override
    public void init() {
        replaceFragment(R.id.vActivityRoot, RootFragment.newInstance());
    }

    public static void start(Context context, final Class activity) {
        Intent starter = new Intent(context, activity);
        starter.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }
}

package ar.com.wolox.android.training.ui.root;

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
}

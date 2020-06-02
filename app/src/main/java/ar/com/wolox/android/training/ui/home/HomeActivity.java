package ar.com.wolox.android.training.ui.home;

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
}

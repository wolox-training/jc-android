package ar.com.wolox.android.training.ui.root;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * My <b>RootFragment</b>.
 */
public class RootFragment extends WolmoFragment<RootPresenter> implements IRootView {

    public static RootFragment newInstance() {
        return new RootFragment();
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.activity_root;
    }

    @Override
    public void showLoginScreen() {
        RootActivity.start(this.getContext(), LoginActivity.class);
    }

    @Override
    public void showHomeScreen() {
        RootActivity.start(this.getContext(), HomeActivity.class);
    }
}

interface IRootView {

    void showLoginScreen();

    void showHomeScreen();
}

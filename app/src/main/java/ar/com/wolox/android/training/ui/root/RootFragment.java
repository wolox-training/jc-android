package ar.com.wolox.android.training.ui.root;

import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * My <b>SignUpFragment</b>.
 */
public class RootFragment extends WolmoFragment<RootPresenter> implements IRootView {

    private static RootFragment instance;
    private RootPresenter presenter;

    public static RootFragment newInstance() {
        if (instance == null) {
            instance = new RootFragment();
        }
        return instance;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.activity_root;
    }

    @Override
    public void getLoginView() {
        final Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void getHomeView() {
        final Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

interface IRootView {

    void getLoginView();

    void getHomeView();
}

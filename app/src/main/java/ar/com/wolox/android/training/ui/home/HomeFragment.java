package ar.com.wolox.android.training.ui.home;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>HomeFragment</b>. */
public class HomeFragment extends WolmoFragment<HomePresenter> implements IHomeView {

    private static HomeFragment instance;

    public static HomeFragment newInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

}

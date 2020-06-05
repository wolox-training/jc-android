package ar.com.wolox.android.training.ui.home;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>HomeFragment</b>. */
public class HomeFragment extends WolmoFragment<HomePresenter> implements IHomeView {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

}

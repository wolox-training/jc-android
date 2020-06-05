package ar.com.wolox.android.training.ui.home;

import android.os.Bundle;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/** My <b>HomeFragment</b>. */
public class HomeFragment extends WolmoFragment<HomePresenter> implements IHomeView {

    private static final String ARG_CAUGHT = "homeFragment_caught";

    public static HomeFragment newInstance(final String caught) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CAUGHT, caught);
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

}

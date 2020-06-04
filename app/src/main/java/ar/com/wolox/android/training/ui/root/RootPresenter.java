package ar.com.wolox.android.training.ui.root;

import java.util.Objects;

import javax.inject.Inject;

import ar.com.wolox.android.training.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * My <b>RootPresenter</b>.
 */
public class RootPresenter extends BasePresenter<IRootView> {

    private final UserSession userSession;

    @Inject
    public RootPresenter(final UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void onViewAttached() {
        checkUser();
    }

    public void checkUser() {
        if (userSession.isUserLogged()) {
            Objects.requireNonNull(this.getView()).getHomeView();
        } else {
            Objects.requireNonNull(this.getView()).getLoginView();
        }
    }
}

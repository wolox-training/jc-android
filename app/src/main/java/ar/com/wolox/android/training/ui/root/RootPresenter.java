package ar.com.wolox.android.training.ui.root;

import com.google.common.base.Strings;

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

    public void checkUser() {
        final String userName = userSession.getUsername();
        if (Strings.isNullOrEmpty(userName)) {
            Objects.requireNonNull(this.getView()).getLoginView();
        }
        Objects.requireNonNull(this.getView()).getHomeView();
    }
}

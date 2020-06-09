package ar.com.wolox.android.training.ui.login;

/** My <b>LoginView</b>. */
public interface ILoginView {

    void showSignUpScreen();

    void showHomeScreen();

    void goToLink(String url);

    void invalidFormatEmail();

    void invalidEmptyEmail();

    void invalidEmptyPassword();

    void invalidUserCredentials();

    void showLoading();

    void stopLoading();

    void failConnection();
}

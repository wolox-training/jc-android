package ar.com.wolox.android.training.ui.login;

/**
 * My <b>LoginErrors</b>.
 */
public enum LoginErrors {

    INVALID_FORMAT_EMAIL {
        public void showError(final ILoginView view) {
            view.invalidFormatEmail();
        }
    },
    EMPTY_EMAIL {
        public void showError(final ILoginView view) {
            view.invalidEmptyEmail();
        }
    },
    EMPTY_PASSWORD {
      public void showError(final ILoginView view) {
          view.invalidEmptyPassword();
      }
    };

    public abstract void showError(ILoginView view);
}

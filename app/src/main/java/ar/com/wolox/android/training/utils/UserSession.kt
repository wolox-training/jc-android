package ar.com.wolox.android.training.utils

import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager

import javax.inject.Inject

@ApplicationScope
class UserSession @Inject constructor(private val sharedPreferencesManager: SharedPreferencesManager) {

    var username: String? = null
        get() {
            if (field == null) {
                field = sharedPreferencesManager.get(Extras.UserLogin.USERNAME, null)
            }
            return field
        }
        set(username) {
            field = username
            sharedPreferencesManager.store(Extras.UserLogin.USERNAME, username)
        }

    var userId: Integer? = null
        get() {
            return field
        }

    var isUserLogged = username != null
}

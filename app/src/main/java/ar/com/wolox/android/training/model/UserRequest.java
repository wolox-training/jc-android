package ar.com.wolox.android.training.model;

import java.util.HashMap;
import java.util.Map;

/**
 * My <b>UserRequestModel</b>.
 */
public class UserRequest {

    private String email;
    private String password;

    public UserRequest(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Map<String, String> getUserQuery() {
        Map<String, String> userQuery = new HashMap<>();
        userQuery.put("email", email);
        userQuery.put("password", password);
        return userQuery;
    }
}

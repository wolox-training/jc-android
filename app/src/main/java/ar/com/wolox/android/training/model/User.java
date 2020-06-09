package ar.com.wolox.android.training.model;

/**
 * My <b>UserModel</b>.
 */
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String picture;
    private String cover;
    private String description;
    private String location;
    private String name;
    private String phone;

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }
}

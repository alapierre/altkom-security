package pl.atlkom.security.ex02.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2016-06-23.
 */
@Entity
public class User {

    @Id
    private String login;

    @NotNull
    private String password;

    private boolean enabled;

    @ManyToMany
    private Set<Role> roles;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChange;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

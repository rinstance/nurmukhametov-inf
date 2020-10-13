package cookie.models;

import lombok.*;

public class UserWithCookie {
    private String login;
    private String password;
    private String uuid;

    public UserWithCookie(String login, String password, String uuid) {
        this.login = login;
        this.password = password;
        this.uuid = uuid;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

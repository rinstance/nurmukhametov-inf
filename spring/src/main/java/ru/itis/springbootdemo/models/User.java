package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private State state;
    private String confirmCode;

    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public State getState() {
        return state;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }
}

package com.training.loanappsystem.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // surrogate PK for JPA convenience

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(nullable = false)
    private String authority;

    public Authority(User user, String authority) {
        this.user = user;
        this.authority = authority;
    }

    public Authority() {

    }

    public Authority(Long id, User user, String authority) {
        this.id = id;
        this.user = user;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(id, authority1.id) && Objects.equals(user, authority1.user) && Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, authority);
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", user=" + user +
                ", authority='" + authority + '\'' +
                '}';
    }
}

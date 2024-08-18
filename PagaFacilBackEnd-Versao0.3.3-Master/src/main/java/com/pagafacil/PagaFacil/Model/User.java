package com.pagafacil.PagaFacil.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "user")
public class User {
    public interface CriarUser { }
    public interface UpdateUser { }

    public static final String TABLE_NAME = "user";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100,nullable = false,unique = true)
    @NotNull(groups = CriarUser.class)
    @NotEmpty(groups = CriarUser.class)
    @Size(groups = CriarUser.class,min = 2, max = 100)
    private String username;


    @Column(name = "password", length = 60,nullable = false)
    @NotNull(groups = {CriarUser.class,UpdateUser.class})
    @NotEmpty(groups = {CriarUser.class,UpdateUser.class})
    @Size(groups = {CriarUser.class,UpdateUser.class},min = 8, max = 100)
    private String password;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // get and set´s
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}

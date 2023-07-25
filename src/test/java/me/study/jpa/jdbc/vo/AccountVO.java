package me.study.jpa.jdbc.vo;

public class AccountVO {

    private Integer id;
    private String username;
    private String password;

    public AccountVO(String newUser, String newPassword) {
        this.username = newUser;
        this.password = newPassword;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccountVO() {
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


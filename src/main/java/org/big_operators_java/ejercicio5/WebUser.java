package org.big_operators_java.ejercicio5;

public class WebUser {
    private String loginId;
    private String password;
    private UserState state;
    private Customer customer;

    public WebUser(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
        this.state = UserState.New;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

enum UserState {
    New, Active, Blocked, Banned
}
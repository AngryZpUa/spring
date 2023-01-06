package com.example.spring3;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private LoggedUserManagementService loggedUserManagementService;
    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login(){
        if (username.equals("Angry") && password.equals("test")) {
            loggedUserManagementService.setUsername(username);
            return true;
        }
        else {
            return false;
        }
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
}

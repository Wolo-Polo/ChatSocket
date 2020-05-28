/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;


/**
 *
 * @author Truong
 */
public class Login implements ActionListener{
    private LoginView loginView;
    private String username=null, password=null;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        username=loginView.getjTextField1().getText();
        //pass;
        
        loginView.setVisible(false);
    }

    public Login() {
    }

    public Login(LoginView loginView) {
        this.loginView = loginView;
    }
    
    public Login(LoginView loginView, String username, String password) {
        this.loginView = loginView;
        this.username = username;
        this.password = password;
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

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }
    
    
    
}

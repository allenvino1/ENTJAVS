package apc.entjava.lavatory;

/**
 * Created by Kervi on 12/14/2016.
 */

import apc.entjava.lavatory.businesslogic.UserService;
import apc.entjava.lavatory.dao.UserDao;
import apc.entjava.lavatory.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {

    private UserService userService = new UserDao();

    private User user;
    private String username;
    private String password;

    public User getUser() {
        if(this.user==null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        String pass = this.password;
        this.password = "";
        return pass;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        this.user = this.userService.login(this.username, this.password);
        if(this.user != null) {
            return "success";
        }
        else {
            return "login";
        }

    }

    public String register() {
        if(user.getPassword().equals(password)) {
            this.userService.register(user);
            return "login";
        }
        return "register";
    }
}

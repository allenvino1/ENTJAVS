package apc.entjava.lavatory.businesslogic;

import apc.entjava.lavatory.model.User;
/**
 * Created by Kervi on 12/14/2016.
 */
public interface UserService {
    void register(User newUser);
    User login(String userName, String password);
}

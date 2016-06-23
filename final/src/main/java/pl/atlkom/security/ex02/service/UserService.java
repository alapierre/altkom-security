package pl.atlkom.security.ex02.service;

import org.springframework.security.access.annotation.Secured;

/**
 * Created by Administrator on 2016-06-21.
 */
public interface UserService {

    void changeUserPassword(String userName, String newPass);


    void changeOwnPassword(String newPass);

    String getLoggedUserName();
}

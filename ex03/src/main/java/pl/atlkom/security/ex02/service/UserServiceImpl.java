package pl.atlkom.security.ex02.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016-06-21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Secured("ROLE_ADMIN")
    public void changeUserPassword(String userName, String newPass) {
        System.out.println("zmiana hasła");
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    public void changeOwnPassword(String newPass) {
        System.out.println("zmiana hasła własnego");
    }

}

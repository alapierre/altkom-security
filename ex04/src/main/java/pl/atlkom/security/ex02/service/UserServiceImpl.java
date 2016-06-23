package pl.atlkom.security.ex02.service;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016-06-21.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserService.class);

    @Secured("ROLE_ADMIN")
    public void changeUserPassword(String userName, String newPass) {
        System.out.println("zmiana hasła");
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    public void changeOwnPassword(String newPass) {
        System.out.println("zmiana hasła własnego");
    }

    public String getLoggedUserName() {

        SecurityContext ctx = SecurityContextHolder.getContext();

        if(ctx != null) {
            Authentication auth = ctx.getAuthentication();

            if(auth != null) {
                Object cred = auth.getAuthorities();

                User user = (User) auth.getPrincipal();

                return user.getUsername();
            } else {
                logger.error("brak danych autoryzacyjnych");
            }
        } else {
            logger.error("brak SecurityContext");
        }

        return "";
    }

}

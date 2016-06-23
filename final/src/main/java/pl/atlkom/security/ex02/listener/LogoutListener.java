/**
 * Copyright 2016-06-23 the original author or authors.
 */
package pl.atlkom.security.ex02.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pl.atlkom.security.ex02.service.GiodoLogService;

import java.util.List;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Component
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent> {

    @Autowired
    private GiodoLogService giodoLogService;

    public void onApplicationEvent(SessionDestroyedEvent event) {

        List<SecurityContext> lstSecurityContext = event.getSecurityContexts();
        UserDetails ud;
        for (SecurityContext securityContext : lstSecurityContext) {
            ud = (UserDetails) securityContext.getAuthentication().getPrincipal();


        }


    }


}

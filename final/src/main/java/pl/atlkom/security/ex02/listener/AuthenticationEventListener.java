/**
 * Copyright 2016-06-23 the original author or authors.
 */
package pl.atlkom.security.ex02.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Service;
import pl.atlkom.security.ex02.service.GiodoLogService;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Service
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

    @Autowired
    private GiodoLogService giodoLogService;

    public void onApplicationEvent(AbstractAuthenticationEvent event) {

        System.out.printf("event");

        if(event instanceof AbstractAuthenticationFailureEvent) {

            giodoLogService.logLoginFailed((AbstractAuthenticationFailureEvent) event);
        } else if (event instanceof AuthenticationSuccessEvent) {

            giodoLogService.logLoginSuccess((AuthenticationSuccessEvent) event);
        }



    }

}

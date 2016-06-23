package pl.atlkom.security.ex02.service;

import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import pl.atlkom.security.ex02.model.BaseEntity;
import pl.atlkom.security.ex02.model.GiodoLogOperationType;

/**
 * Created by Administrator on 2016-06-23.
 */
public interface GiodoLogService {
    void logLoginSuccess(AuthenticationSuccessEvent event);

    void logLoginFailed(AbstractAuthenticationFailureEvent event);

    void log(BaseEntity entity, GiodoLogOperationType operationType);

    void log(String entityClassName, long id, GiodoLogOperationType operationType);
}

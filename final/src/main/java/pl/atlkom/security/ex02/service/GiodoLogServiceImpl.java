package pl.atlkom.security.ex02.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.atlkom.security.ex02.model.BaseEntity;
import pl.atlkom.security.ex02.model.GiodoLog;
import pl.atlkom.security.ex02.model.GiodoLogOperationType;
import pl.atlkom.security.ex02.repository.GiodoLogRepository;

import java.util.Date;

/**
 * Created by Administrator on 2016-06-23.
 */
@Service
public class GiodoLogServiceImpl implements GiodoLogService {

    Logger logger = Logger.getLogger(GiodoLogServiceImpl.class);

    @Autowired
    private GiodoLogRepository repository;

    @Autowired
    private UserService userService;

    public void logLogout(String userName, long timestamp) {

        GiodoLog log = new GiodoLog();

        log.setOperationType(GiodoLogOperationType.LOGOUT);
        log.setDate(new Date(timestamp));
        log.setLogin(userName);

        repository.save(log);

        logger.debug(log);
    }

    public void logLoginSuccess(AuthenticationSuccessEvent event) {

        GiodoLog log = new GiodoLog();

        log.setOperationType(GiodoLogOperationType.LOGIN);
        log.setDate(new Date(event.getTimestamp()));

        User user = (User) event.getAuthentication().getPrincipal();

        log.setLogin(user.getUsername());

        repository.save(log);

        logger.debug(log);
    }

    public void logLoginFailed(AbstractAuthenticationFailureEvent event) {

        System.out.println("!!!!!!!!!!!!!!");

        GiodoLog log = new GiodoLog();

        log.setOperationType(GiodoLogOperationType.LOGIN_FAILED);
        log.setDate(new Date(event.getTimestamp()));
        log.setLogin((String) event.getAuthentication().getPrincipal());

        repository.save(log);

        logger.debug(log);
    }

    public void log(BaseEntity entity, GiodoLogOperationType operationType) {

        GiodoLog log = new GiodoLog();

        log.setDate(new Date());
        log.setEntityId(entity.getId());
        log.setLogin(userService.getLoggedUserName());
        log.setEntityName(entity.getClass().getName());
        log.setOperationType(operationType);

        repository.save(log);

        logger.debug(log);


    }

    public void log(String entityClassName, long id, GiodoLogOperationType operationType) {

        GiodoLog log = new GiodoLog();

        log.setDate(new Date());
        log.setEntityId(id);
        log.setLogin(userService.getLoggedUserName());
        log.setEntityName(entityClassName);
        log.setOperationType(operationType);

        repository.save(log);

        logger.debug(log);


    }
}

package pl.atlkom.security.ex02.service;

import org.apache.log4j.Logger;
import org.hibernate.envers.Audited;
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

    @Audited
    private GiodoLogRepository repository;

    @Audited
    private UserService userService;

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

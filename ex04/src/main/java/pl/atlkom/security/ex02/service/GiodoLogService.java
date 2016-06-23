package pl.atlkom.security.ex02.service;

import pl.atlkom.security.ex02.model.BaseEntity;
import pl.atlkom.security.ex02.model.GiodoLogOperationType;

/**
 * Created by Administrator on 2016-06-23.
 */
public interface GiodoLogService {
    void log(BaseEntity entity, GiodoLogOperationType operationType);

    void log(String entityClassName, long id, GiodoLogOperationType operationType);
}

package pl.atlkom.security.ex02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.atlkom.security.ex02.model.GiodoLog;

/**
 * Created by Administrator on 2016-06-23.
 */
@Repository
public interface GiodoLogRepository extends CrudRepository<GiodoLog, Long> {



}

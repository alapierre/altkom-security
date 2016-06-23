package pl.atlkom.security.ex02.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2016-06-23.
 */
@Entity
public class Role {

    @Id
    private String name;
}

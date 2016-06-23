package pl.atlkom.security.ex02.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016-06-23.
 */
@Entity
public class GiodoLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private GiodoLogOperationType operationType;

    private String entityName;

    private Long entityId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GiodoLogOperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(GiodoLogOperationType operationType) {
        this.operationType = operationType;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return "GiodoLog{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", date=" + date +
                ", operationType=" + operationType +
                ", entityName='" + entityName + '\'' +
                ", entityId=" + entityId +
                '}';
    }
}

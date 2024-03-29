package montp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectStatus")
public class ProjectStatusEntity extends GenericEntity {
    @Column private String status;
    @Column private Integer orderNum;

    public ProjectStatusEntity() {}
    public ProjectStatusEntity(String status, Integer ordre) {
        this.status = status;
        this.orderNum = ordre;
    }

    //region GETTERS / SETTERS
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    //endregion

    @Override
    public String toString() {
        return getStatus();
    }
}

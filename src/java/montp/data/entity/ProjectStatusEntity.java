package montp.data.entity;

import javax.persistence.Column;

public class ProjectStatusEntity extends GenericEntity {
    @Column private String status;
    @Column private Integer ordre;

    public ProjectStatusEntity() {}
    public ProjectStatusEntity(String status, Integer ordre) {
        this.status = status;
        this.ordre = ordre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getStatus();
    }
}

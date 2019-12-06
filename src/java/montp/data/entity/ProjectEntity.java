package montp.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Project")
public class ProjectEntity extends GenericEntity {
    @Column private String name;
    @ManyToOne private ClientEntity client;
    @ManyToOne private ProjectStatusEntity status;
    @OneToMany(mappedBy = "project") private List<FacturationEntity> facturations;

    public ProjectEntity() {}
    public ProjectEntity(String name, ClientEntity client, ProjectStatusEntity status) {
        this.name = name;
        this.client = client;
        this.status = status;
    }

    //region GETTERS / SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public ProjectStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusEntity status) {
        this.status = status;
    }

    public List<FacturationEntity> getFacturations() {
        return facturations;
    }

    public void setFacturations(List<FacturationEntity> facturations) {
        this.facturations = facturations;
    }
    //endregion

    @Override
    public String toString() {
        return getName();
    }
}

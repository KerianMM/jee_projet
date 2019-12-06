package montp.data.entity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class FacturationEntity extends GenericEntity {
    @Column private Integer reference;
    @Column private Date facturedAt;
    @Column private Date payedAtMax;
    @Column(nullable = true) private Date payedAt;
    @Column(nullable = true) private String comments;
    @ManyToOne(optional = true) private PayementModeEntity payementMode;
    @ManyToOne private ProjectEntity project;
    @ManyToOne private FacturationStatusEntity status;
    @OneToMany(mappedBy = "facturation") private List<FacturationLineEntity> facturationLines;

    public FacturationEntity() {}

    //region GETTERS / SETTERS
    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public FacturationStatusEntity getStatus() {
        return status;
    }

    public void setStatus(FacturationStatusEntity status) {
        this.status = status;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("facture n°%d", reference);
    }
}

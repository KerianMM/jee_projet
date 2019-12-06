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

    public Date getFacturedAt() {
        return facturedAt;
    }

    public void setFacturedAt(Date facturedAt) {
        this.facturedAt = facturedAt;
    }

    public Date getPayedAtMax() {
        return payedAtMax;
    }

    public void setPayedAtMax(Date payedAtMax) {
        this.payedAtMax = payedAtMax;
    }

    public Date getPayedAt() {
        return payedAt;
    }

    public void setPayedAt(Date payedAt) {
        this.payedAt = payedAt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public PayementModeEntity getPayementMode() {
        return payementMode;
    }

    public void setPayementMode(PayementModeEntity payementMode) {
        this.payementMode = payementMode;
    }

    public List<FacturationLineEntity> getFacturationLines() {
        return facturationLines;
    }

    public void setFacturationLines(List<FacturationLineEntity> facturationLines) {
        this.facturationLines = facturationLines;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("facture n°%d", reference);
    }
}

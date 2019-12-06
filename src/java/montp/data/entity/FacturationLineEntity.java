package montp.data.entity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class FacturationLineEntity extends GenericEntity {
    @Column private String libelle;
    @Column private Float price;
    @Column private Float amount;
    @ManyToOne private FacturationEntity facturation;

    public FacturationLineEntity() {}
    public FacturationLineEntity(String libelle, Float price, Float amount, FacturationEntity facturation) {
        this.libelle = libelle;
        this.price = price;
        this.amount = amount;
        this.facturation = facturation;
    }

    //region GETTERS / SETTERS
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
    //endregion

    public FacturationEntity getFacturation() {
        return facturation;
    }

    public void setFacturation(FacturationEntity facturation) {
        this.facturation = facturation;
    }

    @Override
    public String toString() {
        return libelle;
    }
}

package montp.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class PersonEntity extends GenericEntity {

    //region MEMBERS
    @Column(nullable = false) protected Boolean isCompany = false;
    @Column(nullable = false) protected String firstName;
    @Column(nullable = false) protected String lastName;
    @Column(nullable = false) protected String email;
    @Column protected String telephone;
    @Column protected String addresse;
    @Column protected String zip;
    @Column(nullable = false) protected Date birthDate;
    @Column(nullable = false) protected Float turnover;
    @Column(nullable = false) protected Float taxes;
    //endregion

    public PersonEntity() {}
    public PersonEntity(Boolean isCompany, String firstName, String lastName, String email, Date birthDate, Float turnover, Float taxes) {
        this.isCompany  = isCompany;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.birthDate  = birthDate;
        this.turnover   = turnover;
        this.taxes      = taxes;
    }
    public PersonEntity(Boolean isCompany, String firstName, String lastName, String email, String telephone, Date birthDate, String addresse, String zip, Float turnover, Float taxes) {
        this.isCompany  = isCompany;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.telephone  = telephone;
        this.birthDate  = birthDate;
        this.addresse   = addresse;
        this.zip        = zip;
        this.turnover   = turnover;
        this.taxes      = taxes;
    }

    //region GETTERS / SETTERS
    public Boolean getCompany() {
        return isCompany;
    }

    public void setCompany(Boolean company) {
        isCompany = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Float getTurnover() {
        return turnover;
    }

    public void setTurnover(Float turnover) {
        this.turnover = turnover;
    }

    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName.toUpperCase());
    }
}

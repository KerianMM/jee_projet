package montp.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
public class ClientEntity extends GenericEntity {

    //region MEMBERS
    @Column(nullable = false) private Boolean isCompany = false;
    @Column(nullable = false) private String firstname;
    @Column(nullable = false) private String lastname;
    @Column(nullable = false) private String email;
    @Column private String telephone;
    @Column private String address;
    @Column private String city;
    @Column private String zip;
    @Column(nullable = false) private Date birthDate;
    @Column(nullable = false) private Float turnover;
    @Column(nullable = false) private Float taxes;
    @ManyToOne private PersonEntity person;
    //endregion

    public ClientEntity() {}
    public ClientEntity(Boolean isCompany, String firstName, String lastName, String email, Date birthDate, Float turnover, Float taxes) {
        this.isCompany  = isCompany;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email      = email;
        this.birthDate  = birthDate;
        this.turnover   = turnover;
        this.taxes      = taxes;
    }
    public ClientEntity(Boolean isCompany, String firstName, String lastName, String email, String telephone, Date birthDate, String addresse, String city, String zip, Float turnover, Float taxes) {
        this.isCompany  = isCompany;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email      = email;
        this.telephone  = telephone;
        this.birthDate  = birthDate;
        this.address    = addresse;
        this.city       = city;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        return String.format("%s %s", firstname, lastname.toUpperCase());
    }
}

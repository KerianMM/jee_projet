package montp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity extends GenericEntity {

    //region MEMBERS
    @Column(nullable = false) private Boolean isCompany = false;
    @Column private String firstname;
    @Column private String lastname;
    @Column(nullable = false) private String email;
    @Column private String telephone;
    @Column private String address;
    @Column private String city;
    @Column private String zip;
    @ManyToOne private PersonEntity person;
    //endregion

    public ClientEntity() {}
    public ClientEntity(PersonEntity person) {
        this.person = person;
    }
    public ClientEntity(Boolean isCompany, String firstName, String lastName, String email) {
        this.isCompany  = isCompany;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email      = email;
    }
    public ClientEntity(Boolean isCompany, String firstName, String lastName, String email, String telephone, String addresse, String city, String zip) {
        this.isCompany  = isCompany;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email      = email;
        this.telephone  = telephone;
        this.address    = addresse;
        this.city       = city;
        this.zip        = zip;
    }

    //region GETTERS / SETTERS
    public Boolean getIsCompany() {
        return isCompany;
    }

    public void setIsCompany(Boolean company) {
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

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    //endregion

    @Override
    public String toString() {
        return String.format("%s %s", firstname, lastname.toUpperCase());
    }
}

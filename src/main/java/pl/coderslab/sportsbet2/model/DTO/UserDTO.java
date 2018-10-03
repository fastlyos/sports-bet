package pl.coderslab.sportsbet2.model.DTO;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.sportsbet2.model.Country;
import pl.coderslab.sportsbet2.validators.EmailUnique;
import pl.coderslab.sportsbet2.validators.UsernameUnique;

import javax.validation.constraints.NotNull;

public class UserDTO {
    @UsernameUnique
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private boolean adult;

    @EmailUnique
    @Email
    private String mail;

    @NotNull
    private int bankAccount;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String zip;

    private Country country;

    @NotNull
    private boolean dataProcessingAcknowledgement = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean getDataProcessingAcknowledgement() {
        return dataProcessingAcknowledgement;
    }

    public void setDataProcessingAcknowledgement(boolean dataProcessingAcknowledgement) {
        this.dataProcessingAcknowledgement = dataProcessingAcknowledgement;
    }
}
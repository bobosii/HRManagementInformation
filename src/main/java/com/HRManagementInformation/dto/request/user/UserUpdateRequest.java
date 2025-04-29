package com.HRManagementInformation.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;

import java.sql.Date;

public class UserUpdateRequest {

    @NotBlank(message = "İsim alanı boş olamaz.")
    private String firstName;

    @NotBlank(message = "Soyisim alanı boş olamaz.")
    private String lastName;

    @NotBlank(message = "E-posta adresi boş olamaz.")
    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    private String email;

    @NotBlank(message = "Telefon numarası boş olamaz.")
    private String phone;

    @NotBlank(message = "Şifre boş olamaz.")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır.")
    private String password;

    private Date hireDate;

    @Past(message = "Doğum tarihi geçmiş bir tarih olmalıdır.")
    private Date birthDate;

    public UserUpdateRequest(){}

    public UserUpdateRequest(String firstName, String lastName, String email, String phone, String password, Date hireDate, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
    }

    public @NotBlank(message = "İsim alanı boş olamaz.") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "İsim alanı boş olamaz.") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Soyisim alanı boş olamaz.") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Soyisim alanı boş olamaz.") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "E-posta adresi boş olamaz.") @Email(message = "Geçerli bir e-posta adresi giriniz.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "E-posta adresi boş olamaz.") @Email(message = "Geçerli bir e-posta adresi giriniz.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Telefon numarası boş olamaz.") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Telefon numarası boş olamaz.") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Şifre boş olamaz.") @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Şifre boş olamaz.") @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır.") String password) {
        this.password = password;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public @Past(message = "Doğum tarihi geçmiş bir tarih olmalıdır.") Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Past(message = "Doğum tarihi geçmiş bir tarih olmalıdır.") Date birthDate) {
        this.birthDate = birthDate;
    }
}

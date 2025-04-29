package com.HRManagementInformation.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.NotBlank;

import java.sql.Date;

public class UserSaveRequest {

    @Positive(message = "id pozitif bir deger olmak zorunda")
    @NotNull(message = "id degeri null veya bos olamaz")
    private int id;
    @NotBlank(message = "İsim alanı boş olamaz.")
    private String firstName;
    @NotBlank(message = "Soy isim alanı boş olamaz.")
    private String lastName;
    @NotBlank(message = "E-posta adresi boş olamaz.")
    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    private String email;
    private String phone;
    private String password;
    @NotNull(message = "Tc kimlik numarası boş olamaz !")
    private String tcNo;
//    @ManyToOne
//    private Role role; // Todo
//    private Department department; // Todo
    private Date hireDate;
    @NotNull(message = "Doğum tarihi boş olamaz !")
    @Past(message = "Doğum tarihi geçmiş bir tarihte olmalıdır !")
    private Date birthDate;

    public UserSaveRequest(int id, String firstName, String lastName, String email, String phone, String password, String tcNo, Date hireDate, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.tcNo = tcNo;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
    }

    @Positive(message = "id pozitif bir deger olmak zorunda")
    @NotNull(message = "id degeri null veya bos olamaz")
    public int getId() {
        return id;
    }

    public void setId(@Positive(message = "id pozitif bir deger olmak zorunda") @NotNull(message = "id degeri null veya bos olamaz") int id) {
        this.id = id;
    }

    public @NotBlank(message = "İsim alanı boş olamaz.") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "İsim alanı boş olamaz.") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Soy isim alanı boş olamaz.") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Soy isim alanı boş olamaz.") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "E-posta adresi boş olamaz.") @Email(message = "Geçerli bir e-posta adresi giriniz.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "E-posta adresi boş olamaz.") @Email(message = "Geçerli bir e-posta adresi giriniz.") String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @NotNull(message = "Tc kimlik numarası boş olamaz !") String getTcNo() {
        return tcNo;
    }

    public void setTcNo(@NotNull(message = "Tc kimlik numarası boş olamaz !") String tcNo) {
        this.tcNo = tcNo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public @NotNull(message = "Doğum tarihi boş olamaz !") @Past(message = "Doğum tarihi geçmiş bir tarihte olmalıdır !") Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull(message = "Doğum tarihi boş olamaz !") @Past(message = "Doğum tarihi geçmiş bir tarihte olmalıdır !") Date birthDate) {
        this.birthDate = birthDate;
    }
}

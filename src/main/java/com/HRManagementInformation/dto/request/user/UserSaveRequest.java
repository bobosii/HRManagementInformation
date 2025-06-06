package com.HRManagementInformation.dto.request.user;

import jakarta.validation.constraints.*;
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

    @Positive(message = "Role ID pozitif olmalı")
    private int roleId;

    @Positive(message = "Department ID pozitif olmalı")
    private int departmentId;

    private Date hireDate;

    @NotNull(message = "Doğum tarihi boş olamaz !")
    @Past(message = "Doğum tarihi geçmiş bir tarihte olmalıdır !")
    private Date birthDate;

    public UserSaveRequest() {}

    public UserSaveRequest(int id, String firstName, String lastName, String email, String phone, String password,
                           String tcNo, int roleId, int departmentId, Date hireDate, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.tcNo = tcNo;
        this.roleId = roleId;
        this.departmentId = departmentId;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

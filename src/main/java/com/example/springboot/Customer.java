package com.example.springboot;

import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "Last name is required") // kiem tra xem co rong hay khong
    @Size(min = 2, message = "Last name must be at least 2 characters long")// kiem tra do dai cua chuoi nhap vao
    private String lastName = "";
    @NotNull(message = "is required") // kiem tra xem co rong hay khong
    @Min(value = 0, message = "must be greater than or equal to zero") // kiem tra so luong phai lon hon hoac bang 0
    @Max(value = 10, message = "must be less than or equal to 10")  // kiem tra so luong phai nho hon hoac bang 10
    private Integer freePasses;
    // kiem tra xem co dung dinh dạng hay không (5 ký tự hoặc 5 số)
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

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


    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}

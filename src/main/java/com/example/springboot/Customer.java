package com.example.springboot;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;
    @NotNull(message = "Last name is required") // kiem tra xem co rong hay khong
    @Size(min = 2, message = "Last name must be at least 2 characters long")// kiem tra do dai cua chuoi nhap vao
    private String lastName = "";
    @Min(value = 0, message = "must be greater than or equal to zero") // kiem tra so luong phai lon hon hoac bang 0
    @Max(value = 10, message = "must be less than or equal to 10")  // kiem tra so luong phai nho hon hoac bang 10
    private int freePasses;

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


    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(@Min(value = 0, message = "must be greater than or equal to zero") @Max(value = 10, message = "must be less than or equal to 10") int freePasses) {
        this.freePasses = freePasses;
    }
}

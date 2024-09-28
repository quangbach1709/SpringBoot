package com.example.springboot;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;
    @NotNull(message = "Last name is required") // kiem tra xem co rong hay khong
    @Size(min = 2, message = "Last name must be at least 2 characters long")// kiem tra do dai cua chuoi nhap vao
    private String lastName = "";

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
}

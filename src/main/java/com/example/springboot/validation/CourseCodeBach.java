package com.example.springboot.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // thuc thi class CourseCodeConstraintValidator
@Target({ElementType.METHOD, ElementType.FIELD}) // chi dung cho method va field (variable) khai bao trong class
@Retention(RetentionPolicy.RUNTIME) // thuc thi khi runtime
public @interface CourseCodeBach {

    // define default course code
    public String value() default "BACH"; // gia tri mac dinh cua course code la BACH

    // define default error message
    public String message() default "must start with BACH"; // thong bao loi mac dinh la phai bat dau bang BACH

    // define default groups
    public Class<?>[] groups() default {}; // nhom mac dinh la rong khong co nhom nao duoc chon

    // define default payloads
    public Class<?>[] payload() default {}; // payload mac dinh la rong khong co payload nao duoc chon

}

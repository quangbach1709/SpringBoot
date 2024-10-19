package com.example.springboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCodeBach, String> {
    // thuc thi class CourseCodeConstraintValidator cho annotation CourseCodeBach va kieu du lieu la String

    private String coursePrefix; // khoi tao bien coursePrefix dung de luu tru gia tri cua course code

    @Override
    public void initialize(CourseCodeBach constraintAnnotation) {

        coursePrefix = constraintAnnotation.value(); // lay gia tri cua courseCodeBach
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // kiem tra xem course code co bat dau bang gia tri cua course code khong

        if (s != null) { // neu course code khong rong thi kiem tra xem co bat dau bang gia tri cua course code khong
            return s.startsWith(coursePrefix);
        } else {
            return true; // neu course code rong thi tra ve true tuc la khong co ky tu nao duoc nhap vao
        }


    }
}

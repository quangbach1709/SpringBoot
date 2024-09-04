package com.example.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration //dung de xac dinh day la class cau hinh
public class DemoSecurityConfig {
    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {//tao ra cac user trong bo nho de su dung
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}123")
//                .roles("MANAGER", "EMPLOYEE")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}123")
//                .roles("ADMIN", "MANAGER", "EMPLOYEE")
//                .build();
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }
    //add support for jdbc ... no more in-memory users

    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {//tao ra cac user trong bo nho de su dung	    public UserDetailsManager userDetailsManager(DataSource dataSource) {//tao ra cac user trong database de su dung thay vi luu trong bo nho nhu tren (InMemoryUserDetailsManager)
//        UserDetails john = User.builder()	        return new JdbcUserDetailsManager(dataSource);//su dung JdbcUserDetailsManager de quan ly cac user trong database thay vi luu trong bo nho
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {//tao ra cac user trong database de su dung thay vi luu trong bo nho nhu tren (InMemoryUserDetailsManager)
        //su dung JdbcUserDetailsManager de quan ly cac user trong database thay vi luu trong bo nho
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(//cau lenh de lay thong tin user tu database dua vao username cua user
                "select user_id, pw, active form members where user_id=?"
        );

        //define query to retrieve the authority / role for a user
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(//cau lenh de lay thong tin role cua user dua vao username cua user
                "select user_id, roles from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {//cau hinh cac quyen truy cap cho cac user
        httpSecurity.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        //use httpBasic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());//su dung httpBasic authentication de xac thuc user khi truy cap vao cac resource

        //disable cross site request forgery (CSRF)
        httpSecurity.csrf(csrf -> csrf.disable());//tat chuc nang CSRF de don gian hoa viec test

        return httpSecurity.build();
    }
}

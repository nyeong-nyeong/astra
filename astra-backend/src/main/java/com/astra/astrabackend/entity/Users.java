package com.astra.astrabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(name = "id" , columnNames = "id")})
@NoArgsConstructor
public class Users {

    @Id
    private String id;
    @Column(name="pw")
    private String pw;
    @Column(name="address")
    private String address;
    @Column(name="name")
    private String name;
    @Column(name="f_email")
    private String fEmail;
    @Column(name="s_email")
    private String sEmail;
    @Column(name="gender")
    private String gender;
    @Column(name="birthday")
    private LocalDateTime birthDay;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name = "age")
    private Long age;

    @Builder
    public Users(String id, String pw, String address, String name, String fEmail, String sEmail, String gender, LocalDateTime birthDay, String phoneNumber, Long age) {
        this.id = id;
        this.pw = pw;
        this.address = address;
        this.name = name;
        this.fEmail = fEmail;
        this.sEmail = sEmail;
        this.gender = gender;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }


}

package com.astra.astrabackend.dto;

import com.astra.astrabackend.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UsersResponseDTO {

    private String id;
    private String address;
    private String name;
    private String fEmail;
    private String sEmail;
    private String gender;
    private String phoneNumber;
    private LocalDateTime birthday;
    private Long age;

    public UsersResponseDTO(Users users) {
        this.id = users.getId();
        this.age = users.getAge();
        this.address = users.getAddress();
        this.name = users.getName();
        this.fEmail = users.getFEmail();
        this.sEmail = users.getSEmail();
        this.birthday = users.getBirthDay();
        this.phoneNumber = users.getPhoneNumber();
        this.gender = users.getGender();
    }
}

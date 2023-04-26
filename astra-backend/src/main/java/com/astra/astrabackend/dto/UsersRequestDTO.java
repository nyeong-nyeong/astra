package com.astra.astrabackend.dto;

import com.astra.astrabackend.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UsersRequestDTO {

    private String id;

    private String pw;

    private String address;

    @Override
    public String toString() {
        return "UsersRequestDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }

    private String name;

    private String email;

    private String gender;

    private String phoneNumber;

    private LocalDateTime birthday;

    private Long age;

    public Users toEntityForCreate(String pw){
        return Users.builder()
                .id(id)
                .pw(pw)
                .address(address)
                .age(age)
                .email(email)
                .gender(gender)
                .name(name)
                .birthDay(birthday)
                .phoneNumber(phoneNumber)
                .build();
    }

}

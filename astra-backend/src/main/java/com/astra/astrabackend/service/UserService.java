package com.astra.astrabackend.service;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.dto.UsersResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public void newUsers(UsersRequestDTO dto);

    public ResponseEntity<?> login(String id , String pw);

    public List<UsersResponseDTO> UsersList();

}

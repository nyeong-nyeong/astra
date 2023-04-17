package com.astra.astrabackend.service;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.dto.UsersResponseDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public void newUsers(UsersRequestDTO dto);

    public ResponseEntity<?> login(String id , String pw , HttpSession session);

    public List<UsersResponseDTO> UsersList();

}

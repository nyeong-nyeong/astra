package com.astra.astrabackend.service;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.dto.UsersResponseDTO;

import java.util.List;

public interface UserService {

    public void newUsers(UsersRequestDTO dto);

    public UsersResponseDTO login(String id , String pw);

    public List<UsersResponseDTO> UsersList();

}

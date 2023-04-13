package com.astra.astrabackend.service.impl;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.dto.UsersResponseDTO;
import com.astra.astrabackend.repository.UsersRepository;
import com.astra.astrabackend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public void newUsers(UsersRequestDTO dto) {
        repository.save(dto.toEntityForCreate(passwordEncoder.encode(dto.getPw())));
    }

    @Override
    public ResponseEntity<?> login(String id, String pw) {
        if(repository.findById(id).isEmpty()){
            return new ResponseEntity<>("No Such Id", HttpStatus.OK);
        } else {
        if(passwordEncoder.matches(pw , repository.findById(id).get().getPw())) {
            log.info(":: 로그인 성공 ::");
            return new ResponseEntity<>(new UsersResponseDTO(repository.findById(id).orElseThrow()), HttpStatus.OK);
        } else {
            log.warn(":: 로그인 실패 ::");
            return new ResponseEntity<>("wrong password", HttpStatus.OK);
        }
        }
    }

    @Override
    public List<UsersResponseDTO> UsersList() {
        return null;
    }

}

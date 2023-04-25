package com.astra.astrabackend.service.impl;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.dto.UsersResponseDTO;
import com.astra.astrabackend.repository.UsersRepository;
import com.astra.astrabackend.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UsersRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UsersRepository repository , PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public void newUsers(UsersRequestDTO dto) {
        repository.save(dto.toEntityForCreate(passwordEncoder.encode(dto.getPw())));
    }

    @Override
    public ResponseEntity<?> login(String id, String pw , HttpSession session) {
        if(repository.findById(id).isEmpty()){
            return new ResponseEntity<>("No Such Id", HttpStatus.OK);
        } else {
        if(passwordEncoder.matches(pw , repository.findById(id).get().getPw())) {
            log.info(":: 로그인 성공 ::");
            session.setAttribute( "username", id);
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

    @Override
    public String isExistId(String id){
        if(repository.findById(id).isEmpty()){
            return "OK";
        }
        return null;
    }

}

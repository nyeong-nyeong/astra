package com.astra.astrabackend.controller;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.dto.UsersResponseDTO;
import com.astra.astrabackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping
    public void newUsers(@RequestBody UsersRequestDTO dto){
        userService.newUsers(dto);
    }

    @GetMapping("/{pw}")
    public UsersResponseDTO login(@RequestParam(value = "id") String id , @PathVariable String pw) {
        return userService.login(id , pw);
    }
}

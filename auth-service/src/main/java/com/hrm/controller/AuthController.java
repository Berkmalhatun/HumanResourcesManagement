package com.hrm.controller;


import com.hrm.dto.request.NewRegisterRequestDto;
import com.hrm.dto.response.RegisterResponseDto;
import com.hrm.exception.AuthServiceException;
import com.hrm.exception.ErrorType;
import com.hrm.repository.entity.Auth;
import com.hrm.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.hrm.constants.ApiUrls.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid NewRegisterRequestDto dto){
        if(!dto.getPassword().equals(dto.getRePassword())){
            throw new AuthServiceException(ErrorType.PASSWORD_UNMATCH);
        }
        return ResponseEntity.ok(authService.register(dto));
    }






}
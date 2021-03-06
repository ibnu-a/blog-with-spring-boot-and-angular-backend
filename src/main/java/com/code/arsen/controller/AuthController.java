package com.code.arsen.controller;

import com.code.arsen.dto.AuthenticationResponse;
import com.code.arsen.dto.LoginRequest;
import com.code.arsen.dto.RegisterRequest;
import com.code.arsen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        return authService.login(loginRequest);
    }
}

package com.abhinav3254.flight.service;

import com.abhinav3254.flight.dto.LoginRequest;
import com.abhinav3254.flight.dto.ServerResponse;
import com.abhinav3254.flight.dto.SignupRequest;
import com.abhinav3254.flight.exception.CustomException;
import com.abhinav3254.flight.jwt.JwtUtils;
import com.abhinav3254.flight.model.User;
import com.abhinav3254.flight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<?> register(SignupRequest signupRequest) {
        User user = setUpUser(signupRequest);
        userRepository.save(user);
        ServerResponse<String> response = new ServerResponse<>("User Added!");
        return ResponseEntity.status(200).body(response);
    }

    private User setUpUser(SignupRequest signupRequest) {
        User user = new User();
        if (signupRequest.getEmail().isEmpty() || signupRequest.getPhone().isEmpty() || signupRequest.getPassword().isEmpty()) throw new CustomException("Fields can't be empty", HttpStatus.BAD_REQUEST);
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(signupRequest.getPassword());
        user.setPhone(signupRequest.getPhone());
        user.setGender(signupRequest.getGender());
        user.setRole("USER");
        return user;
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isEmpty()) throw new CustomException("User not found by email "+loginRequest.getEmail(),HttpStatus.NOT_FOUND);
        User user = userOptional.get();
        if (user.getPassword().equals(loginRequest.getPassword())) {
            String token = jwtUtils.generateToken(user.getEmail(),user.getId(),user.getRole());
            return ResponseEntity.status(200).body(new ServerResponse<>(token));
        } throw new CustomException("Incorrect Password!",HttpStatus.BAD_REQUEST);
    }
}

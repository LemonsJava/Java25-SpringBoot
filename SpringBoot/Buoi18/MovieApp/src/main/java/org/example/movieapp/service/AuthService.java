package org.example.movieapp.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.User;
import org.example.movieapp.model.enums.UserRole;
import org.example.movieapp.model.request.CreateNewUserRequest;
import org.example.movieapp.model.request.LoginRequest;
import org.example.movieapp.repository.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final HttpSession session;

    public void login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        //Co the luu trong cookie, db, redis,...
        session.setAttribute("currentUser", user);
    }

    public void logout() {
        session.removeAttribute("currentUser");
    }

    public void register(CreateNewUserRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new RuntimeException("Name cannot be empty");
        }

        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new RuntimeException("Email cannot be empty");
        }

        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new RuntimeException("Password cannot be empty");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .avatar("https://placehold.co/600x400?text=" + request.getName().substring(0, 1).toUpperCase())
                .role(UserRole.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
}

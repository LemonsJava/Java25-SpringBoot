package org.example.movieapp.rest;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.model.request.UpdatePasswordUserRequest;
import org.example.movieapp.model.request.UpdateProfileUserRequest;
import org.example.movieapp.model.response.ErrorResponse;
import org.example.movieapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @PutMapping("/api/users/update-profile")
    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileUserRequest request) {
        try {
            userService.updateProfile(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PutMapping("/api/users/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordUserRequest request) {
        try {
            userService.updatePassword(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}

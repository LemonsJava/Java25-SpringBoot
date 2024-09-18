package org.example.movieapp.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class ErrorResponse {
    HttpStatus status;
    String message;

    //Path, Actor, time
}

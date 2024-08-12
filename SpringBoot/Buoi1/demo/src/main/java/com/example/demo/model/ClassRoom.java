package com.example.demo.model;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)


public class ClassRoom {
//    @Autowired
//    Student student;
//    @Autowired
//    Teacher teacher;

    Student student;
    Teacher teacher;

    public ClassRoom(Student student, Teacher teacher) {
        this.student = student;
        this.teacher = teacher;
    }
}

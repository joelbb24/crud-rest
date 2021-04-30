package com.jardevs.learning.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Course> courses;

    public Student(String firstName, String lastName, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }
}

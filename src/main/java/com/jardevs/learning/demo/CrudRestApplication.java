package com.jardevs.learning.demo;

import com.jardevs.learning.demo.model.Course;
import com.jardevs.learning.demo.model.Student;
import com.jardevs.learning.demo.repo.CourseRepository;
import com.jardevs.learning.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CrudRestApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(CrudRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        repo.save(new Student("Joel", "Raj", Arrays.asList(new Course("Maths"), new Course("Physics"), new Course("Chemistry"))));
        repo.save(new Student("Neema", "Peter", Arrays.asList(new Course("Maths"), new Course("Physics"), new Course("Chemistry"))));
        repo.save(new Student("Joe", "Hackman", Arrays.asList(new Course("Maths"), new Course("Physics"), new Course("Chemistry"))));
    }
}
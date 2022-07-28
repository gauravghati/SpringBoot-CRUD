package com.springboot.firstApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // URL Path : http://localhost:8080/onestudent
    @GetMapping("/onestudent")
    public Student getStudent() {
        return new Student("Gaurav", "Ghati");
    }

    // URL Path : http://localhost:8080/allstudents
    @GetMapping("/allstudents")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Name", "Surname"));
        students.add(new Student("Test", "Name"));
        students.add(new Student("Test 2", "Name 2"));

        return students;
    }

    // URL Path : http://localhost:8080/student/gaurav/ghati
    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    // URL Path : http://localhost:8080/student?firstName=gaurav&lastName=ghati
    @GetMapping("/student")
    public Student studentQueryParameter(@RequestParam("firstName") String firstName,
                                         @RequestParam("lastName") String lastName ) {
        return new Student(firstName, lastName);
    }
}

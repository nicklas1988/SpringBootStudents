package com.test.Dao;

import com.test.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>() {

            {
                put(1, new Student(1, "Student 1", "Computer Science"));
                put(2, new Student(2, "Student 2", "Computer Science"));
                put(3, new Student(3, "Student 3", "Math"));
                put(4, new Student(4, "Student 4", "English"));
            }

        };
    }

    public Collection<Student> getAllStudents(){
        return students.values();

        }

    public Student getStudentById(int id){
        return students.get(id);
    }

    public void removeStudentById(int id) {
        students.remove(id);
    }

    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void insertStudentToDb(Student student) {
        students.put(student.getId(), student);
    }
}

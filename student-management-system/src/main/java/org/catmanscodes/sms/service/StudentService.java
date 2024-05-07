package org.catmanscodes.sms.service;

import org.catmanscodes.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> studentList();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto studentDto);

    void deleteStudentByID(Long studentId);


}

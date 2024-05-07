package org.catmanscodes.sms.service.impl;

import lombok.AllArgsConstructor;
import org.catmanscodes.sms.dto.StudentDto;
import org.catmanscodes.sms.entity.Student;
import org.catmanscodes.sms.mapper.StudentMapper;
import org.catmanscodes.sms.repository.StudentRepository;
import org.catmanscodes.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> studentList() {

        List<Student> studentList = studentRepository.findAll();

        List<StudentDto> studentDtoList = studentList.stream()
                .map(student -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());

        return studentDtoList;
    }

    @Override
    public void createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);

        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {

        Student student = studentRepository.findById(studentId).get();

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {

        studentRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudentByID(Long studentId) {

        studentRepository.deleteById(studentId);
    }


}

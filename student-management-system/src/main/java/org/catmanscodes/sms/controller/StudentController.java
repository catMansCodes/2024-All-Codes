package org.catmanscodes.sms.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.catmanscodes.sms.dto.StudentDto;
import org.catmanscodes.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class StudentController {


    private StudentService studentService;

    // 1. Get All Students

    @GetMapping("/students")
    public String studentList(Model model) {
        List<StudentDto> studentDtoList = studentService.studentList();

        model.addAttribute("students", studentDtoList);

        return "student-list";
    }

    // 2. Create New Student form load
    @GetMapping("/students/load")
    public String addNewStudentLoad(Model model) {

        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);

        return "student-create";
    }

    // 3. Create New Student save to database
    @PostMapping("/students/save")
    public String addNewStudentSave(@Valid @ModelAttribute("student") StudentDto studentDto,
                                    BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("student", studentDto);
            return "student-create";
        }

        studentService.createStudent(studentDto);

        return "redirect:/students";
    }

    // 4. Edit student Load page
    @GetMapping("/students/{studentId}/edit")
    public String editStudentPage(@PathVariable("studentId") Long studentId, Model model) {
        StudentDto studentDto = studentService.getStudentById(studentId);

        model.addAttribute("student", studentDto);
        return "student-edit";
    }

    // 5. Update student in database
    @PostMapping("/students/update/{studentId}")
    public String updateStudent(@Valid @ModelAttribute("student") StudentDto studentDto, @PathVariable("studentId") Long studentId,
                                Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("student", studentDto);
            return "student-edit";
        }
        studentDto.setId(studentId);

        studentService.updateStudent(studentDto);

        return "redirect:/students";
    }

    // 6. Delete Student
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId, Model model) {

        studentService.deleteStudentByID(studentId);

        return "redirect:/students";
    }

    // 7. View Student details
    @GetMapping("/students/{studentId}/view")
    public String viewStudentDetails(@PathVariable("studentId") Long studentId, Model model) {

        StudentDto studentDto = studentService.getStudentById(studentId);

        model.addAttribute("student",studentDto);

        return "student-detail";
    }

}

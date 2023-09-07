package com.example.restjava10.api;

import com.example.restjava10.dto.*;
import com.example.restjava10.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(name="Student Api")
public class StudentApi {

    private final StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR')")//or @PermitAll
    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public SimpleResponse saveStudent(@RequestBody @Valid StudentRequestRecord studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR')")
    @GetMapping("/{studentId}")
    public StudentResponse getById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{studentId}")
    public SimpleResponse updateStudent(@PathVariable Long studentId,
                                        @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentId, studentRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{studentId}")
    public SimpleResponse deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/pagination")
    public PaginationResponse pagination(
            @RequestParam int currentPage,
            @RequestParam int pageSize){
        return studentService.getAllByPagination(currentPage,pageSize);

    }


}

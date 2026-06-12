package com.example.RestAPI.Controller;


import com.example.RestAPI.DTO.AddStudentReqDto;
import com.example.RestAPI.DTO.Studentdto;
import com.example.RestAPI.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;



    @GetMapping
    public ResponseEntity<List<Studentdto>> getStudent() {
      //   return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getAllStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Studentdto> createNewStudent(@RequestBody AddStudentReqDto addStudentReqDto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentReqDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentService> updateStudent(@PathVariable String id, @RequestBody AddStudentReqDto addStudentReqDto) {
        return ResponseEntity.ok((StudentService) studentService.updateStudent(id,addStudentReqDto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<StudentService> updatePartialStudent(@PathVariable String id, @RequestBody Map<String,Object> updates) {
        return ResponseEntity.ok((StudentService) studentService.updatePartialStudent(id,updates));
    }
}

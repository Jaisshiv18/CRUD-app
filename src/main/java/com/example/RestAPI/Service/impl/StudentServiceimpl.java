package com.example.RestAPI.Service.impl;

import com.example.RestAPI.DTO.AddStudentReqDto;
import com.example.RestAPI.DTO.Studentdto;
import com.example.RestAPI.Entity.Student;
import com.example.RestAPI.Repository.StudentRepository;
import com.example.RestAPI.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Studentdto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.
                stream().
                map((Student student) -> new Studentdto(student.getId(),student.getName(),student.getEmail()))
                        .toList();
    }

    @Override
    public Studentdto getAllStudentById(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));


        return modelMapper.map(student, Studentdto.class);
    }

    @Override
    public Studentdto createNewStudent(AddStudentReqDto addStudentReqDto) {
        Student newStudent = modelMapper.map(addStudentReqDto,Student.class);
        Student student =studentRepository.save(newStudent);

        return modelMapper.map(student,Studentdto.class);
    }

    @Override
    public void deleteStudentById(String id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not found by:"+ id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Studentdto updateStudent(String id, AddStudentReqDto addStudentReqDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        modelMapper.map(addStudentReqDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student,Studentdto.class);
    }

    @Override
    public Studentdto updatePartialStudent(String id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        updates.forEach((field,value)-> {
            switch (field) {
                case "name" : student.setName((String) value);
                break;
                case "email" : student.setEmail((String) value);
                break;
                default :
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedstudent = studentRepository.save(student);
        return modelMapper.map(savedstudent,Studentdto.class);
    }


}

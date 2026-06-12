package com.example.RestAPI.Service;

import com.example.RestAPI.DTO.AddStudentReqDto;
import com.example.RestAPI.DTO.Studentdto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Studentdto> getAllStudent();


    Studentdto getAllStudentById(String id);

    Studentdto createNewStudent(AddStudentReqDto addStudentReqDto);

    void deleteStudentById(String id);

    Studentdto updateStudent(String id, AddStudentReqDto addStudentReqDto);

    Studentdto updatePartialStudent(String id, Map<String, Object> updates);
}

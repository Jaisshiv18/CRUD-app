package com.example.RestAPI.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studentdto {
    private String id;
    private String name;
    private String email;

}

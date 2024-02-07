package com.dulanjanalakshan.userservice.dto;

import com.dulanjanalakshan.userservice.enums.Role;
import com.dulanjanalakshan.userservice.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserData {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String heading;
    private String about;
    private String contact;
    private Date create;
    private Date update;
    private Status status;
    private Role type;
    private String username;
    private String password;
}

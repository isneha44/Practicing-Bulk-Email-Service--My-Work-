package com.dulanjanalakshan.userservice.entity;

import com.dulanjanalakshan.userservice.enums.Role;
import com.dulanjanalakshan.userservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HEADING")
    private String heading;
    @Column(name = "ABOUT")
    private String about;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "CREATE_DATE")
    private Date create;
    @Column(name = "UPDATE_DATE")
    private Date update;
    @Column(name = "STATUS")
    private Status status;
    @Column(name = "USER_TYPE")
    private Role type;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "RESET_TOKEN")
    private int resetToken;
}

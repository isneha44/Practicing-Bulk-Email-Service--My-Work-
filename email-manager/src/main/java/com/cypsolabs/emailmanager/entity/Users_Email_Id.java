package com.cypsolabs.emailmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Table(name = "t_User's_Email_Id's")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Users_Email_Id {

    @Id
    @Column(name = "ID")
    private UUID id;
    @Id
    @Column(name = "USER-ID")
    private UUID user_id;
    @Column(name = "CREATE_DATE")
    private Date createDate;
}

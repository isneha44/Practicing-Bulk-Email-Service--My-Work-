package com.cypsolabs.emailmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email_maneger")
public class EmailManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "USER-ID")
    private UUID user_id;
    @Column(name = "OWNER_NAME")
    private String owner_name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
}

package com.dulanjanalakshan.systemlog.entity;

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
@Table(name = "t_systemlog")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Systemlog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "USER")
    private UUID userid;
    @Column(name = "Message")
    private String message;
    @Column(name = "Location")
    private String location;
    @Column(name = "CREATEDATE")
    private Date createDate;

}

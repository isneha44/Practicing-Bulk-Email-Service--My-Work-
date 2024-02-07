package com.cypsolabs.commentservice.enitiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_customer_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "USER_ID")
    private UUID userid;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "CREATE_DATE")
    private Date create;
    @Column(name = "STARS")
    private int stars;
}

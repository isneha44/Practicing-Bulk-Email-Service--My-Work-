package com.dulanjanalakshan.whatsappmanager.entity;


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
 * @author Imalka Gayani
 */
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_whatsapp")
public class WhatsappManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID user_id;
    @Column(name = "COUNTY_CODE")
    private String country_code;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "OWNER_NAME")
    private String owner_name;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;







}

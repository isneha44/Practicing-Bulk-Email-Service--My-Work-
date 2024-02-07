package com.cypsolabs.emailmanager.repository;

import com.cypsolabs.emailmanager.entity.Users_Email_Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Users_Email_Id_Repository extends JpaRepository<Users_Email_Id, UUID> {
}

package com.cypsolabs.emailmanager.repository;

import com.cypsolabs.emailmanager.entity.EmailManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface EmailManagerRepository extends JpaRepository<EmailManager, UUID> {

    boolean existsByEmail(String email);

    Optional<EmailManager> findByEmail(String email);



}

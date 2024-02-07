package com.dulanjanalakshan.userservice.repository;

import com.dulanjanalakshan.userservice.entity.User;
import com.dulanjanalakshan.userservice.enums.Role;
import com.dulanjanalakshan.userservice.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Dulanjana Lakshan Kumarasingha
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByType(Role userRole);
    List<User> findByStatus(Status status);
    List<User> findByUsername(String username);
    Optional<User> findById(UUID uuid);
    List<User> findByContact(String contact);
    List<User> findByEmail(String email);
    Optional<User> findByResetToken(int resetToken);
}

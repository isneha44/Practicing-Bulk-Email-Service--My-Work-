package com.dulanjanalakshan.whatsappmanager.repository;

import com.dulanjanalakshan.whatsappmanager.entity.WhatsappManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface WhatsappManagerRepository extends JpaRepository<WhatsappManager, UUID> {

    Optional<WhatsappManager> findByMobile(String mobile);

    boolean existsByMobile(String mobile);

    Optional<WhatsappManager> findById(UUID id);
}

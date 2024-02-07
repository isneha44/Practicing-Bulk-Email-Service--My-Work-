package com.dulanjanalakshan.systemlog.repository;

import com.dulanjanalakshan.systemlog.entity.Systemlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
/**
 * @author Imalka Gayani
 */

public interface SystemlogRepository extends JpaRepository <Systemlog,UUID> {
    Systemlog save(Systemlog systemlog);
    Optional<Systemlog> findByUserid(UUID userid);

    Optional<Systemlog> findByLocation(String location);
}

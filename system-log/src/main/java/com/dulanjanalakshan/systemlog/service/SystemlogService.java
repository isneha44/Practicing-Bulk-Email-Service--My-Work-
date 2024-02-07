package com.dulanjanalakshan.systemlog.service;

import com.dulanjanalakshan.systemlog.entity.Systemlog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */

public interface SystemlogService {
    Systemlog saveSystemlog (Systemlog systemlog);
    List<Systemlog> getAllSystemlog();

    Optional<Systemlog> findByUserid(UUID userid);
    Optional<Systemlog> findByLocation(String location);

}

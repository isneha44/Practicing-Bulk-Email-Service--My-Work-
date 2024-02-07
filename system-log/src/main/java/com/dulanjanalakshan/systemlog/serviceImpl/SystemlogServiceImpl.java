package com.dulanjanalakshan.systemlog.serviceImpl;

import com.dulanjanalakshan.systemlog.entity.Systemlog;
import com.dulanjanalakshan.systemlog.repository.SystemlogRepository;
import com.dulanjanalakshan.systemlog.service.SystemlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */

@Service
@RequiredArgsConstructor
public class SystemlogServiceImpl implements SystemlogService {

    @Autowired
    private final SystemlogRepository systemlogRepository;
    @Override
    public Systemlog saveSystemlog(Systemlog systemlog) {
        return systemlogRepository.save(systemlog) ;
    }

    @Override
    public List<Systemlog> getAllSystemlog() {
        return systemlogRepository.findAll();
    }

    @Override
    public Optional<Systemlog> findByUserid(UUID userid) {
        return systemlogRepository.findByUserid(userid);
    }

    @Override
    public Optional<Systemlog> findByLocation(String location) {
        return systemlogRepository.findByLocation(location);
    }


}


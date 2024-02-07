package com.dulanjanalakshan.whatsappmanager.serviceImpl;

import com.dulanjanalakshan.whatsappmanager.entity.WhatsappManager;
import com.dulanjanalakshan.whatsappmanager.repository.WhatsappManagerRepository;
import com.dulanjanalakshan.whatsappmanager.service.WhatsappManagerService;
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
public class WhatsappManagerServiceImpl implements WhatsappManagerService {
    @Autowired
    private final WhatsappManagerRepository whatsappManagerRepository;

    @Override
    public WhatsappManager saveWhatsapp(WhatsappManager whatsappManager) {
        return whatsappManagerRepository.save(whatsappManager);
    }

    @Override
    public List<WhatsappManager> getAllWhatsappManager() {
        return whatsappManagerRepository.findAll();
    }

    @Override
    public Optional<WhatsappManager> findByMobile(String mobile) {
        return whatsappManagerRepository.findByMobile(mobile);
    }

    @Override
    public boolean MobileExistsAllReady(String mobile) {
        return whatsappManagerRepository.existsByMobile(mobile);
    }

    @Override
    public Optional<WhatsappManager> findById(UUID id) {
        return whatsappManagerRepository.findById(id);
    }


}





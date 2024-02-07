package com.dulanjanalakshan.whatsappmanager.service;

import com.dulanjanalakshan.whatsappmanager.entity.WhatsappManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface WhatsappManagerService {
    WhatsappManager saveWhatsapp(WhatsappManager whatsappManager);

    List<WhatsappManager> getAllWhatsappManager();

    Optional<WhatsappManager> findByMobile(String mobile);

    boolean MobileExistsAllReady(String mobile);

    Optional<WhatsappManager> findById(UUID id);




}

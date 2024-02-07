package com.cypsolabs.emailmanager.serviceImpl;


import com.cypsolabs.emailmanager.entity.EmailManager;
import com.cypsolabs.emailmanager.entity.Users_Email_Id;
import com.cypsolabs.emailmanager.repository.EmailManagerRepository;
import com.cypsolabs.emailmanager.repository.Users_Email_Id_Repository;
import com.cypsolabs.emailmanager.service.EmailManagerService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor
public class EmailManagerServiceImpl implements EmailManagerService {

    @Autowired
    private final EmailManagerRepository emailManagerRepository;

    @Autowired
    private final Users_Email_Id_Repository usersEmailIdRepository;




    @Override
    public EmailManager SaveEmailManager(EmailManager emailManager) {
        return emailManagerRepository.save(emailManager);
    }

    @Override
    public List<EmailManager> getAllEmailManager() {
        return emailManagerRepository.findAll();
    }

    @Override
    public boolean EmailAllreadyExsits(String email) {
        return emailManagerRepository.existsByEmail(email);
    }

    @Override
    public Optional<EmailManager> findByEmail(String email) {
        return emailManagerRepository.findByEmail(email);
    }

    @Override
    public Optional<EmailManager> findById(UUID id) {
        return emailManagerRepository.findById(id);
    }

    public List<EmailManager> readExcelFile(MultipartFile file) throws IOException {
        List<EmailManager> emailManagers = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = (Sheet) workbook.getSheetAt(0);

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {

                    continue;
                }
                EmailManager emailManager = extractEmailManagerFromRow(currentRow);
                emailManagers.add(emailManager);
            }
        }
        return emailManagers;
    }

    private EmailManager extractEmailManagerFromRow(Row row) {
        EmailManager emailManager = new EmailManager();
        emailManager.setUser_id(UUID.fromString(row.getCell(0).getStringCellValue()));
        emailManager.setOwner_name(row.getCell(1).getStringCellValue());
        emailManager.setEmail(row.getCell(2).getStringCellValue());
        emailManager.setCreateDate(new Date());
        emailManager.setUpdateDate(new Date());
        return emailManager;
    }

    public void saveAllEmailManagers(List<EmailManager> emailManagers) {
        emailManagerRepository.saveAll(emailManagers);
    }

    @Override
    public void processExcelFile(MultipartFile file) {

    }

    @Override
    public void processCsvFile(MultipartFile file) {

    }

    @Override
    public Users_Email_Id SaveEmailDetails(Users_Email_Id usersEmailId) {
        return usersEmailIdRepository.save(usersEmailId);
    }
}

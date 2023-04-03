package com.example.onetoone.services;

import com.example.onetoone.models.Passport;
import com.example.onetoone.repositories.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PassportService {
    private final PassportRepository passportRepository;
    @Autowired
    public PassportService(PassportRepository passportRepository){
        this.passportRepository = passportRepository;
    }

    //получить все паспорта
    public List<Passport> getAllPassport(){
        return passportRepository.findAll();
    }

    //добавление паспорта
    @Transactional(readOnly = false)
    public void addPassport(Passport passport){
        passportRepository.save(passport);
    }
}

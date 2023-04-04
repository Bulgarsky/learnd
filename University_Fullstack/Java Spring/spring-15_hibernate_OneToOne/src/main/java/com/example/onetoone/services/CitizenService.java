package com.example.onetoone.services;

import com.example.onetoone.models.Citizen;
import com.example.onetoone.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CitizenService {
    private final CitizenRepository citizenRepository;
    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    //вернуть всех ситизен
    public List<Citizen> getAllCitizen(){
        return citizenRepository.findAll();
    }

    //добавление ситизена
    @Transactional(readOnly = false)
    public void addCitizen(Citizen citizen){
        citizenRepository.save(citizen);
    }
}

package com.example.onetoone.contollers;


import org.springframework.ui.Model;
import com.example.onetoone.models.Passport;
import com.example.onetoone.models.Citizen;
import com.example.onetoone.repositories.PassportRepository;
import com.example.onetoone.services.CitizenService;
import com.example.onetoone.services.PassportService;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final PassportService passportService;
    private final CitizenService citizenService;
    private final PassportRepository passportRepository;

    public MainController(PassportService passportService, CitizenService citizenService, PassportRepository passportRepository) {
        this.passportService = passportService;
        this.citizenService = citizenService;
        this.passportRepository = passportRepository;
    }


    //получение всех ситизен и view
    @GetMapping("/citizen")
    public String getAllCitizen(Model model){
        model.addAttribute("citizens", citizenService.getAllCitizen());
        return "citizen";
    }

    //получение всех паспортов и передать в view
    @GetMapping("/passport")
    public String getAllPassport(Model model){
        model.addAttribute("passports", passportService.getAllPassport());
        return "passport";
    }

    //view с добавлением ситизена
    @GetMapping("/citizen/add")
    public String addCitizen(Model model){
        model.addAttribute("addCitizen", new Citizen());
        model.addAttribute("passports", passportService.getAllPassport());
        return "add_citizen";
    }

    //
    @PostMapping("/citizen/add")
    public String addCitizen(
                @ModelAttribute("citizen") @Valid Citizen addCitizen,
                BindingResult bindingResult,
                @RequestParam String number,
                Model model){

        Passport passport = passportRepository.findByNumber(number);
        Citizen newCitizen = new Citizen(addCitizen.getLastName(), addCitizen.getFirstName(), addCitizen.getMiddleName(), passport);

        for(Citizen citizenDB : citizenService.getAllCitizen()) {
            if(citizenDB.getPassport().getId() == newCitizen.getPassport().getId()) {
                model.addAttribute("addCitizen", addCitizen);
                model.addAttribute("passports", passportService.getAllPassport());
                // выводить просто сообщение об ошибке (без указания где она)
                 //model.addAttribute("passportError", "Гражданин с таким паспортом существует!");

                //массив ошибок
                ObjectError error= new ObjectError("error", "Гражданин с таким паспортом существует!");
                bindingResult.addError(error);
                return "add_citizen";
            }
        }
        citizenService.addCitizen(newCitizen);
        return "redirect:/citizen";
    }

}

package com.example.onetomany.controllers;

import com.example.onetomany.models.Address;
import com.example.onetomany.models.Person;
import com.example.onetomany.repositories.AddressRepository;
import com.example.onetomany.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/person")
    public String index(Model model) {
//        List<Address> addresses = addressRepository.findAll();
//        model.addAttribute("address", addresses);
        model.addAttribute("address", addressRepository.findAll());
        model.addAttribute("persons", personRepository.findAll());
        return "person";
    }

    @GetMapping("/person/add")
    public String addPerson(Model model){
        model.addAttribute("addresses", addressRepository.findAll());
        return "add_person";
    }

    @PostMapping("/person/add")
    public String addPerson(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String street){
        Address address = addressRepository.findByStreet(street);
        Person addPerson = new Person(lastName, firstName, middleName, address);
        personRepository.save(addPerson);
        return "redirect:/person";
    }
}

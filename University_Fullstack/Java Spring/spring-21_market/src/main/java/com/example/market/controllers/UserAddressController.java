package com.example.market.controllers;

import com.example.market.enumm.ShippingAddressStatus;
import com.example.market.models.Person;
import com.example.market.models.ShippingAddress;
import com.example.market.security.PersonDetails;
import com.example.market.services.PersonService;
import com.example.market.services.ShippingAddressService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.market.enumm.ShippingAddressStatus.ADDRESS_STATUS;


@Controller
public class UserAddressController {
    private final ShippingAddressService shippingAddressService;
    private final PersonService personService;

    public UserAddressController(ShippingAddressService shippingAddressService, PersonService personService) {
        this.shippingAddressService = shippingAddressService;
        this.personService = personService;
    }


    @GetMapping("/user/addresses")
    public String userAddresses(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        List<ShippingAddress> userAddressList = shippingAddressService.findAddressesByPerson(personDetails.getPerson());

        int addressCount=0;
        for (ShippingAddress address: userAddressList) {
            addressCount+=1;
        }

        model.addAttribute("userAuth", personDetails.getPerson());
        model.addAttribute("userAddressesList", userAddressList);
        model.addAttribute("userAddressCount", addressCount);
        return "/user/userAddresses";
    }

    @GetMapping("/shipping/address/add")
    public String addShippingAddress(Model model){
        model.addAttribute("shippingAddress", new ShippingAddress());
        return "/shipping/addShipping";
    }

    @PostMapping("/shipping/address/add")
    public String addShippingAddress(
            @ModelAttribute("shippingAddress") @Valid ShippingAddress shippingAddress,
            @RequestParam("zip") String zip,
            @RequestParam("country") String country,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("building") String building,
            @RequestParam("apartment") String apartment
            ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int personId = personDetails.getPerson().getId();

        ShippingAddress newAddress = new ShippingAddress(zip, country, state, city, street, building, apartment, ADDRESS_STATUS, personDetails.getPerson());
        shippingAddressService.saveAddress(newAddress, personId);
        return "redirect:/user/addresses";
    }

    @GetMapping("/user/address/edit/{id}")
    public String editShippingAddress(
            Model model,
            @PathVariable("id")int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        model.addAttribute("user", shippingAddressService.getAddressById(id).getPerson());
//        model.addAttribute("status", shippingAddressService.getAddressById(id).getAddressStatus());
        model.addAttribute("editAddress", shippingAddressService.getAddressById(id));
        return "/shipping/editShipping";
    }

    @PostMapping("/user/address/edit/{id}")
    public String saveShippingAddress(
            @ModelAttribute("editAddress") ShippingAddress updatedAddress,
//            @ModelAttribute("user") Person person,
            @PathVariable("id")int id,
            Model model
    ){
        ShippingAddressStatus currentStatus = shippingAddressService.getAddressById(id).getAddressStatus();
        Person tempPerson = shippingAddressService.getAddressById(id).getPerson();
        int personId = tempPerson.getId();
        shippingAddressService.updateAddress(id, updatedAddress, currentStatus, personId);


        return "redirect:/user/addresses";
    }

    @GetMapping("/user/address/delete/{id}")
    public String deleteAddress(
            @PathVariable("id")int id){
        shippingAddressService.deleteAddress(id);
        return "redirect:/user/addresses";
    }

    @GetMapping("/user/address/default/{id}")
    public String setDefaultAddress(
            @PathVariable("id")int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int personId = personDetails.getPerson().getId();
        ShippingAddress address = shippingAddressService.getAddressById(id);
        shippingAddressService.setDefault(id, personId, address);

        return "redirect:/user/addresses";
    }



}

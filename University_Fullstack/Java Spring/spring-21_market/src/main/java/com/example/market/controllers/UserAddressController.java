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
    private final AuthenticationController authController;

    public UserAddressController(ShippingAddressService shippingAddressService, AuthenticationController authController) {
        this.shippingAddressService = shippingAddressService;
        this.authController = authController;
    }

    //список адресов
    @GetMapping("/user/addresses")
    public String userAddresses(Model model) {
        Person currentPerson = authController.getCurrentAuthPerson();

        List<ShippingAddress> userAddressList = shippingAddressService.findAddressesByPerson(currentPerson);

        model.addAttribute("userAuth", currentPerson);
        model.addAttribute("userAddressesList", userAddressList);
        model.addAttribute("userAddressCount", userAddressList.size());
        return "/user/userAddresses";
    }
    //добавление адреса
    @GetMapping("/shipping/address/add")
    public String addShippingAddress(Model model){
        model.addAttribute("shippingAddress", new ShippingAddress());
        return "/shipping/addShipping";
    }
    //добавление нового адреса в базу
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
        Person currentPerson = authController.getCurrentAuthPerson();
        ShippingAddress newAddress = new ShippingAddress(zip, country, state, city, street, building, apartment, ADDRESS_STATUS, currentPerson);
        shippingAddressService.saveAddress(newAddress, currentPerson.getId());
        return "redirect:/user/addresses";
    }
    //редактирование адреса
    @GetMapping("/user/address/edit/{id}")
    public String editShippingAddress(
            Model model,
            @PathVariable("id")int id){

        model.addAttribute("user", shippingAddressService.getAddressById(id).getPerson());
        model.addAttribute("editAddress", shippingAddressService.getAddressById(id));
        return "/shipping/editShipping";
    }
    //редактирование адреса - обновление в базе
    @PostMapping("/user/address/edit/{id}")
    public String saveShippingAddress(
            @ModelAttribute("editAddress") ShippingAddress updatedAddress,
            @PathVariable("id")int id,
            Model model
    ){
        ShippingAddressStatus currentStatus = shippingAddressService.getAddressById(id).getAddressStatus();
        Person currentPerson = authController.getCurrentAuthPerson();
        shippingAddressService.updateAddress(id, updatedAddress, currentStatus, currentPerson.getId());
        model.addAttribute("userAuth", currentPerson);
        return "redirect:/user/addresses";
    }
    //удаление адреса пользователем
    @GetMapping("/user/address/delete/{id}")
    public String deleteAddress(
            @PathVariable("id")int id){
        shippingAddressService.deleteAddress(id);
        return "redirect:/user/addresses";
    }

    //установить статус адреса по умолчанию
    @GetMapping("/user/address/default/{id}")
    public String setDefaultAddress(
            @PathVariable("id")int id){
        int personId = authController.getCurrentAuthPerson().getId();
        ShippingAddress address = shippingAddressService.getAddressById(id);
        shippingAddressService.setDefault(id, personId, address);

        return "redirect:/user/addresses";
    }



}

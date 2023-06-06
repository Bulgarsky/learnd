package com.example.market.services;

import com.example.market.enumm.ShippingAddressStatus;
import com.example.market.models.Person;
import com.example.market.models.ShippingAddress;
import com.example.market.repositories.ShippingAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.market.enumm.ShippingAddressStatus.ADDRESS_STATUS;
import static com.example.market.enumm.ShippingAddressStatus.DEFAULT_ADDRESS_STATUS;

@Service
@Transactional
public class ShippingAddressService {
    private final ShippingAddressRepository shippingAddressRepository;
    private final PersonService personService;

    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository, PersonService personService) {
        this.shippingAddressRepository = shippingAddressRepository;
        this.personService = personService;
    }

    //найти все адреса
    public List<ShippingAddress> getAllAddress(){
        return shippingAddressRepository.findAll();
    }

    //найти адреса конкретного пользователя
    public List<ShippingAddress> findAddressesByPerson(Person person){
        return shippingAddressRepository.findByPerson(person);
    }
    //найти адрес по умолчанию
    public ShippingAddress findDefaultAddress(int person_id){
        Optional<ShippingAddress> DefaultUserAddress = shippingAddressRepository.findByPersonDefaultAddress(person_id);

        return DefaultUserAddress.orElse(null);
    }




    //найти конкретный адрес по id
    public  ShippingAddress getAddressById(int id){
        Optional<ShippingAddress> optionalShippingAddress = shippingAddressRepository.findById(id);
        return optionalShippingAddress.orElse(null);
    }
    //сохранить адрес в базу (+)
    @Transactional
    public void saveAddress(ShippingAddress address, int personId){
        ShippingAddress newAddress = new ShippingAddress();
        Person person = personService.getPersonId(personId);
        newAddress.setZip(address.getZip());
        newAddress.setCountry(address.getCountry());
        newAddress.setState(address.getState());
        newAddress.setCity(address.getCity());
        newAddress.setStreet(address.getStreet());
        newAddress.setBuilding(address.getBuilding());
        newAddress.setApartment(address.getApartment());
        //Проверка, если в базе нет адресов, тогда установить адрес по умолчанию, иначе задать обычный статус
        if (shippingAddressRepository.findByPerson(person).isEmpty()) {
            newAddress.setAddressStatus(DEFAULT_ADDRESS_STATUS);
        }else {
            newAddress.setAddressStatus(ADDRESS_STATUS);
        }
        newAddress.setPerson(person);
        shippingAddressRepository.save(newAddress);
    }
    //обновить адрес
    public void updateAddress(int addressId, ShippingAddress updatedAddress, ShippingAddressStatus currentStatus, int personId){
        ShippingAddress saveAddress = new ShippingAddress();
        Person person = personService.getPersonId(personId);
        saveAddress.setId(addressId);
        saveAddress.setZip(updatedAddress.getZip());
        saveAddress.setCountry(updatedAddress.getCountry());
        saveAddress.setState(updatedAddress.getState());
        saveAddress.setCity(updatedAddress.getCity());
        saveAddress.setStreet(updatedAddress.getStreet());
        saveAddress.setBuilding(updatedAddress.getBuilding());
        saveAddress.setApartment(updatedAddress.getApartment());
        saveAddress.setAddressStatus(currentStatus);
        saveAddress.setPerson(person);
        shippingAddressRepository.save(saveAddress);
    }
    //удалить адрес
    @Transactional
    public void deleteAddress(int id){
        shippingAddressRepository.deleteById(id);
    }

    //установить статус адреса
    public void setDefault(int addressId, int personId, ShippingAddress currentAddress){
        Person person = personService.getPersonId(personId);
        List<ShippingAddress> addressList = shippingAddressRepository.findByPerson(person);
        ShippingAddressStatus status = ADDRESS_STATUS;

        for (ShippingAddress address: addressList) {
            updateAddress(address.getId(), address, status, personId);
        }

        ShippingAddressStatus newStatus = DEFAULT_ADDRESS_STATUS;
        updateAddress(addressId, currentAddress, newStatus, personId);
    }


}

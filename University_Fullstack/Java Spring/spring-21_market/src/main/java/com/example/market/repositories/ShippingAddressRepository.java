package com.example.market.repositories;

import com.example.market.models.Person;
import com.example.market.models.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

    List<ShippingAddress> findByPerson(Person person);

    @Query(value="select * from shipping_address where person_id = ?1 and address_status = 0", nativeQuery = true)
    Optional<ShippingAddress> findByPersonDefaultAddress(int person_id);
}

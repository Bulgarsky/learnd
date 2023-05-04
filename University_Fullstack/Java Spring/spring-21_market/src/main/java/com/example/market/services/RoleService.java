//package com.example.market.services;
//
//import com.example.market.models.Role;
//import com.example.market.repositories.RoleRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RoleService {
//    private final RoleRepository roleRepository;
//
//    public RoleService(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    public List<Role> getAllRole(){
//        return roleRepository.findAll();
//    }
//
//    public Role getRoleId(int id){
//        Optional<Role> optionalRole = Optional.ofNullable(roleRepository.findById(id));
//        return  optionalRole.orElse(null);
//    }
//}

package com.example.users.services;


import com.example.users.models.User;
import com.example.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //метод позв вернуть всех пользователей в листе
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //поиск по id и возврат объекта через контейнер(обертку) optional
    public User getUserId(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        //select * from user_site where id = {id}
        return optionalUser.orElse(null);
    }

    //метод для добавления пользователя в таблицу user_site
    @Transactional //(readOnly = false) default
    public void addUser(User user) {
        //insert into user_site(lastname, firstname etc) values ( , , , , )
        userRepository.save(user);
    }

    //метод обновления пользователя в бд
    @Transactional
    public void editUser(int id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    //метод для удаления пользотваеля из БД
    @Transactional
    public void deleteUser(int id) {
        //DELETE FROM USER_SITE WHERE ID={id}
        userRepository.deleteById(id);
    }
}

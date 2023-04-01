package com.example.users.dao;

import com.example.users.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoUser {
    private int id;
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
        user.setId(++id);
    }
    public User getUserId(int id){
        for (User item: userList) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
        //lambda
        //return userList.stream().filter(user -> user.getId() == id).findAny().orElse((null));
    }

    public void updateUser(int id, User user) {
        User userUpdate = getUserId(id);
        userUpdate.setLastName(user.getLastName());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setMiddleName(user.getMiddleName());
        userUpdate.setAge(user.getAge());
        userUpdate.setEmail(user.getEmail());
    }
}

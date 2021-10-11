package tn.esprit.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.entities.User;

public interface UserService {

List<User> retrieveAllUsers();

User addUser(User u);
void deleteUser(String id);
User updateUser(User u);
User retrieveUser(String id);
}

package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
@Autowired

	UserRepository userRepository ; 
	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll() ;
		
	}

	@Override
	public User addUser(User u) {
		userRepository.save(u) ;
		
		return u;
	}

	@Override
	public void deleteUser(String id) {
		
		userRepository.deleteById(Long.parseLong(id));
		
		
	}

	@Override
	public User updateUser(User u) {
		userRepository.save(u) ;
		return u;
	}

	@Override
	public User retrieveUser(String id) {
		
		return	userRepository.findById(Long.parseLong(id)).orElse(null);
		 
		
	}

}

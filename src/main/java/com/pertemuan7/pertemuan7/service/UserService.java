package com.pertemuan7.pertemuan7.service;

import com.pertemuan7.pertemuan7.model.User;
import com.pertemuan7.pertemuan7.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User adduser(User request){
        request.setId(UUID.randomUUID().toString());
        return userRepository.save(request);
    }

    public List<User> getAllusers(){
        return  userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(String id, User request){
        User existinguer = userRepository.findById(id).orElse(null);
        if (existinguer != null){
            existinguer.setName(request.getName());
            existinguer.setNim(request.getNim());
            return  userRepository.save(existinguer);
        }
        return null;
    }

    public void deleteUser (String id)
    {
        userRepository.deleteById(id);
    }
}

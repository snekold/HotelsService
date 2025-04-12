package org.example.hotelsservice.service;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.example.hotelsservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserId(Long id) {
        return userRepository.findById(id);
    }


    public User updateUser(Long id, User userInfo) {
        return userRepository.findById(id).map( user -> {
            user.setUsername(userInfo.getUsername());
            user.setPassword(userInfo.getPassword());
        return userRepository.save(user);
    }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }



    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }
}

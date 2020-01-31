package com.jiratask.crud.service;

import com.jiratask.crud.dto.UserDTO;
import com.jiratask.crud.model.User;
import com.jiratask.crud.repository.RoleRepository;
import com.jiratask.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findById(int id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else
            return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(int id, UserDTO userDTO) {
        User originalUser;
        if (userRepository.findById(id).isPresent()) {
            originalUser = userRepository.findById(id).get();
            originalUser.setName(userDTO.getName());
            originalUser.setPassword(userDTO.getPassword());
            originalUser.setEmail(userDTO.getEmail());
            originalUser.setRole(roleRepository.findById(userDTO.getRoleId()).get());
            return userRepository.save(originalUser);
        } else
            return null;
    }

//    Updating existing user as *deleted*, instead of actual delete
    public User deleteUser(int id) {
        User originalUser;
        if (userRepository.findById(id).isPresent()) {
            originalUser = userRepository.findById(id).get();
            originalUser.setName("*deleted*");
            originalUser.setPassword("*deleted*");
            originalUser.setEmail("*deleted*");
            originalUser.setRole(roleRepository.findById(3).get());
            return userRepository.save(originalUser);
        } else
            return null;
    }
}

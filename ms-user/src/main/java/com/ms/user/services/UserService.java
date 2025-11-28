package com.ms.user.services;

import com.ms.user.dao.UserRepository;
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public UserModel save(UserModel user){
        var userDTO = userRepository.save(user);
        userProducer.publishMessageEmail(userDTO);
        return userDTO;
    }
}

package br.com.LightWeightAPI.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(UsetDTO userDTO) {
        User user = new User(userDTO);
        this.repository.save(user);

        return user;
    }
}


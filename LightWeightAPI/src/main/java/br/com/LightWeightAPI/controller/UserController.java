package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.user.User;
import br.com.LightWeightAPI.domain.user.UserService;
import br.com.LightWeightAPI.domain.user.UsetDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity createUser(@Valid @RequestBody UsetDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = this.userService.createUser(userDTO);

        return ResponseEntity.ok(user.getLogin());
    }
}

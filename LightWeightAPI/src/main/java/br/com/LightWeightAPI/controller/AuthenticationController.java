package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.user.User;
import br.com.LightWeightAPI.domain.user.UserDTO;
import br.com.LightWeightAPI.domain.user.UserService;
import br.com.LightWeightAPI.infra.security.TokenDTO;
import br.com.LightWeightAPI.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    @Transactional
    public ResponseEntity createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = this.userService.createUser(userDTO);

        return ResponseEntity.ok(user.getLogin());
    }

    @PostMapping
    public ResponseEntity doLogin(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getLogin(), userDTO.getPassword());
        Authentication authentication = manager.authenticate(authenticationToken);

        String jwt = this.tokenService.generateJWT((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(jwt));
    }

}

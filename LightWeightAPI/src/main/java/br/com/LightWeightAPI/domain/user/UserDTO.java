package br.com.LightWeightAPI.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @Email
    private String login;

    @NotBlank
    private String password;

}

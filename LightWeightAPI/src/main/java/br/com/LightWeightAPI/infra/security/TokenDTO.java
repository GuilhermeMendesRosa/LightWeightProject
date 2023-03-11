package br.com.LightWeightAPI.infra.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {

    private String jwt;

    public TokenDTO(String jwt) {
        this.jwt = jwt;
    }

}

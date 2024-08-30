package br.com.LightWeightAPI.infra.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TokenDTO {

    private String jwt;

    public TokenDTO(String jwt) {
        this.jwt = jwt;
    }

}

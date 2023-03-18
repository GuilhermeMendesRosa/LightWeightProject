package br.com.LightWeightAPI.infra.utils;

import br.com.LightWeightAPI.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class LightWeightUtils {

    public static User getLoggedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

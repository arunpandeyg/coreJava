package com.ragisteration.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ragisteration.login.model.User;
import com.ragisteration.login.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

}

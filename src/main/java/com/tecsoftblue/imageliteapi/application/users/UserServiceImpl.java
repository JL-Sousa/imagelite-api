package com.tecsoftblue.imageliteapi.application.users;

import com.tecsoftblue.imageliteapi.application.jwt.JwtService;
import com.tecsoftblue.imageliteapi.domain.AccessToken;
import com.tecsoftblue.imageliteapi.domain.entity.User;
import com.tecsoftblue.imageliteapi.domain.exception.DuplicatedTupleException;
import com.tecsoftblue.imageliteapi.domain.service.IUserService;
import com.tecsoftblue.imageliteapi.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User save(User user) {
        var possibleUser = getByEmail(user.getEmail());
        if(possibleUser != null) {
            throw new DuplicatedTupleException("User already exists!");
        }
        encodePassword(user);
        return userRepository.save(user);
    }

    @Override
    public AccessToken authenticate(String email, String password) {
        var user = getByEmail(email);
        if (user == null) {
            return null;
        }
        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if(matches) {
            return jwtService.generateToken(user);
        }
        return null;
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}

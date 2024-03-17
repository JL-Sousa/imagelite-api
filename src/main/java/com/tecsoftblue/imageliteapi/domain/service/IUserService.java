package com.tecsoftblue.imageliteapi.domain.service;

import com.tecsoftblue.imageliteapi.domain.AccessToken;
import com.tecsoftblue.imageliteapi.domain.entity.User;

public interface IUserService {

    User getByEmail(String email);
    User save(User user);
    AccessToken authenticate(String email, String password);
}

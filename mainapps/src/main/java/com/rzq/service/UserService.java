package com.rzq.service;

import com.rzq.model.UserLoginRequest;
import com.rzq.model.UserRegisterRequest;
import com.rzq.model.UserTokenResponse;

public interface UserService {
    public void register(UserRegisterRequest request);

    public void register(String token, UserRegisterRequest request);

    public UserTokenResponse login(UserLoginRequest request);
    public void logout(String token);
}

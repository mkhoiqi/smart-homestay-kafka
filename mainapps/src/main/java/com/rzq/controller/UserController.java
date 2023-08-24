package com.rzq.controller;

import com.rzq.model.UserLoginRequest;
import com.rzq.model.UserRegisterRequest;
import com.rzq.model.UserTokenResponse;
import com.rzq.model.WebResponse;
import com.rzq.service.UserService;
import com.rzq.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("")
    public WebResponse<String> register(@RequestHeader(value = "X-API-TOKEN", required = false) String token, @RequestBody UserRegisterRequest request){
        if(token==null){
            userService.register(request);
        } else {
            System.out.println("Masuk");
            userService.register(token, request);
        }

        return WebResponse.<String>builder()
                .data("Ok").build();
    }

    @PostMapping("/login")
    public WebResponse<UserTokenResponse> login(@RequestBody UserLoginRequest request){

        UserTokenResponse response = userService.login(request);
        return WebResponse.<UserTokenResponse>builder()
                .data(response).build();
    }

    @DeleteMapping("")
    public WebResponse<String> logout(@RequestHeader(value = "X-API-TOKEN", required = false) String token){
        userService.logout(token);
        return WebResponse.<String>builder()
                .data("Ok").build();
    }


}

package com.Hotel.Boking.service.interfc;


import com.Hotel.Boking.dto.LoginRequest;
import com.Hotel.Boking.dto.Response;
import com.Hotel.Boking.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}

package com.emergencyfood.PaimonTravelReservation.service;

import com.emergencyfood.PaimonTravelReservation.commons.RestResult;
import com.emergencyfood.PaimonTravelReservation.entity.User;

public interface UserService {

    RestResult login(User user);

    RestResult logout();
}

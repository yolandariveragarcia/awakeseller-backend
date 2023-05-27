package com.awakeseller.awakeseller.service.users;

import com.awakeseller.awakeseller.controller.users.UserDto;

public interface UserService {

  UserDto findByUserName(String username);

}

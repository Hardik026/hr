package com.nagarro.dao;

import com.nagarro.dto.User;

public interface UserDao {
	User validate(String username, String password);
}

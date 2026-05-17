package crm_app12.services;

import crm_app12.UserEntity;
import crm_app12.repository.UserRepository;

//
public class LoginServices {

	private UserRepository userRepository = new UserRepository();

	public UserEntity checkLogin(String email, String password) {

		return userRepository.findUserByEmailandPassword(email, password);
	}
}

package crm_app12.services;

import java.util.List;

import crm_app12.UserEntity;
import crm_app12.repository.UserRepository;

public class UserServices {
	
	private UserRepository userRepository = new UserRepository();
	
	public List<UserEntity> getAll() {
		List<UserEntity> listUserEntities = userRepository.findAll();
		
		return listUserEntities;
	}
	
}


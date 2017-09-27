package com.tsi2.streamrain.converters.user;

import java.util.ArrayList;
import java.util.List;

import com.tsi2.streamrain.converters.interfaces.IConverter;
import com.tsi2.streamrain.datatypes.user.UserDto;
import com.tsi2.streamrain.model.Users;

public class UserConverter implements IConverter<UserDto, Users>{

	public UserDto converter(Users source) {
		UserDto userDto = new UserDto();
		//set de user 
		return userDto;
	}

	public Users deConverter(UserDto source) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDto> convertAll(List<Users> source) {
		List<UserDto> dtoList = new ArrayList<UserDto>();
		for(Users user : source) {
			dtoList.add(converter(user));
		}
		return null;
	}

	public List<Users> deConvertAll(List<UserDto> source) {
		// TODO Auto-generated method stub
		return null;
	}

}

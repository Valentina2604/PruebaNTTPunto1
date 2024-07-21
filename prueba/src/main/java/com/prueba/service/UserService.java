package com.prueba.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.prueba.model.*;

@Service
public class UserService {

	private static final Map<String, UserModel> users = new HashMap<>();
	
	static {
		users.put("C23445322", new UserModel("Juan","Carlos","Gomez","Valencia","23445322","Calle 48 #2 -105","Soacha"));
		users.put("P48712463", new UserModel("Maria","Camila","Linares","Valencia","48712463","Calle 48 #2 -105","Soacha"));
	}
	
	public UserModel getUser(String tipoDoc, String numDoc) {
		return users.get(tipoDoc + numDoc);
	}
}

package com.prueba.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.UserModel;
import com.prueba.service.UserService;

@RestController
@RequestMapping("/prueba/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> obtenerCliente(@RequestParam String tipoDoc, @RequestParam String numDocumento){
		if (!tipoDoc.equals("C")&& !tipoDoc.equals("P")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de documento no valido");
		}
		
		UserModel user = userService.getUser(tipoDoc, numDocumento);
		if (user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> errores(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
	}
}

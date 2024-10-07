package com.openwebinars.rest.users.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.services.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService;

	@PostMapping("/")
	public UserEntity nuevoUsuario(@RequestBody UserEntity newUser) {
		try {
			return userEntityService.nuevoUsuario(newUser);
		} catch (DataIntegrityViolationException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	// This is the original method of course, but it is not used in the course
	// because save method is necesary long id but we send string id
	/*@PostMapping("/")
	public ResponseEntity<UserEntity> nuevoUsuarioResponse(@RequestBody UserEntity newUser) {
		try {
			return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(userEntityService.save(newUser));
			
		} catch (DataIntegrityViolationException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}*/

}

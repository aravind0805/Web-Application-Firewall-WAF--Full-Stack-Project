package com.hashirama.AshBackend.AshController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashirama.AshBackend.DTO.LoginDTO;
import com.hashirama.AshBackend.DTO.RegisterDTO;
import com.hashirama.AshBackend.Service.UserService;

@RestController
@RequestMapping("/Auth")
public class UserController {
	@Autowired
	private UserService userservice;
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto )
	{
		String resultUrl = userservice.loginUser(dto);
	    
	    if ("http://localhost:8081/home".equals(resultUrl)) {
	        return ResponseEntity.ok(resultUrl);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultUrl);
	    }
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDTO dto)
	{
		ResponseEntity<String> result = userservice.registerUser(dto);
	    String url = result.getBody();

	    if ("http://localhost:8081/home".equals(url)) {
	        return ResponseEntity.ok("http://localhost:8081/home");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("http://localhost:8081/register");
	    }

	}
	
}

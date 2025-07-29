package com.hashirama.AshBackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hashirama.AshBackend.DTO.LoginDTO;
import com.hashirama.AshBackend.DTO.RegisterDTO;
import com.hashirama.AshBackend.Repository.RuserRepository;
import com.hashirama.AshBackend.entity.usercr;

import jakarta.transaction.Transactional;


@Service
public class UserService {
    @Autowired
    private RuserRepository ruserRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Transactional
    public ResponseEntity<String> registerUser(RegisterDTO dto) {
    	
    	
    	usercr user = new usercr();
    	
    	
        if (ruserRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("http://localhost:8081/register");
        }
        user.setUser(dto.getUser().trim());
        user.setMail(dto.getEmail().trim());        
        if (dto.getPass() == null || dto.getPass().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Password is missing");
        }

        user.setPass(passwordEncoder.encode(dto.getPass()));

        ruserRepository.save(user);
        return ResponseEntity.ok("http://localhost:8081/home");
    }

    public String loginUser(LoginDTO dto) {
    	 return ruserRepository.findByEmail(dto.getEmail())
    		        .map(user -> {
    		            if (passwordEncoder.matches(dto.getPass(), user.getPass())) {
    		                return "http://localhost:8081/home";  
    		            } else {
    		                return "http://localhost:8081/login"; 
    		            }
    		        })
    		        .orElse("http://localhost:8081/login"); 
    }
	
}

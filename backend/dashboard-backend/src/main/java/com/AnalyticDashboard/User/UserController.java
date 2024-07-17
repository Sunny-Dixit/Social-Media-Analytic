package com.AnalyticDashboard.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalyticDashboard.Analytic.AnalyticRepository;
import com.AnalyticDashboard.Analytic.SocialMediaAnalytics;
import com.AnalyticDashboard.Post.SocialMediaPost;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnalyticRepository analyticRepository;
	
	@Autowired
	private CreateUser createUser;
	
	@PostMapping
	public ResponseEntity<List<SocialMediaUser>> createUser(@RequestBody List<SocialMediaUser> userInput){
		
		List<SocialMediaUser> saveAll = createUser.createUser(userInput);
		
        return ResponseEntity.status(HttpStatus.CREATED).body(saveAll);

		
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<SocialMediaUser> findById(@PathVariable Long id){
        Optional<SocialMediaUser> user = userRepository.findById(id);
        if (user.isPresent()) return ResponseEntity.ok(user.get());
        throw new RuntimeException("User not found");
    }
    
    @GetMapping
    public ResponseEntity<List<SocialMediaUser>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

	

}

package com.AnalyticDashboard.Analytic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalyticDashboard.Post.PostRepository;
import com.AnalyticDashboard.User.SocialMediaUser;
import com.AnalyticDashboard.User.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnalyticController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnalyticRepository analyticRepository;
	
	@Autowired
	private CreateAnalyticImpl createAnalyticImpl;
	
	@GetMapping("/analytic/{id}")
	public ResponseEntity<AnalyticResponse> analytic(@PathVariable Long id){
		
		Long userId = postRepository.findUserIdByPostId(id);
		System.out.print(userId);
		
		AnalyticResponse response = createAnalyticImpl.dashboardAnalyticRespose(userId);

		
		
		System.out.print("response data"+response);
		

		return ResponseEntity.ok(response);

		
		
	}

}

package com.AnalyticDashboard.Analytic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AnalyticDashboard.User.SocialMediaUser;
import com.AnalyticDashboard.User.UserRepository;


@Service
public class CreateAnalyticImpl implements CreateAnalytic{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnalyticRepository analyticRepository;
	
	@Override
	public AnalyticResponse dashboardAnalyticRespose(Long userId) {
		
		Optional<SocialMediaUser> userOptional = userRepository.findById(userId);
		SocialMediaUser user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));
		
		List<SocialMediaAnalytics> analytics = analyticRepository.findAnalyticsByUserId(userId);
		
		AnalyticResponse response = new AnalyticResponse();
		response.setUser(user);
		response.setAnalytics(analytics);
		
		return response;

		
		
	}

}

package com.AnalyticDashboard.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public ResponseEntity<List<SocialMediaPost>> findAll(){
	    List<SocialMediaPost> posts = postRepository.findAll();
	    System.out.print(posts);
	    return ResponseEntity.ok(posts);
	}

}

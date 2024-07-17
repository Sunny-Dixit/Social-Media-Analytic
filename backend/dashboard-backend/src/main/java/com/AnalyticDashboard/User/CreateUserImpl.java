package com.AnalyticDashboard.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AnalyticDashboard.Analytic.AnalyticRepository;
import com.AnalyticDashboard.Analytic.SocialMediaAnalytics;
import com.AnalyticDashboard.Post.SocialMediaPost;

@Service
public class CreateUserImpl implements CreateUser{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnalyticRepository analyticRepository;

	@Override
	public List<SocialMediaUser> createUser(List<SocialMediaUser> userInput) {
		

		List<SocialMediaUser> users = new ArrayList<>();
        for (SocialMediaUser user : userInput) {
            SocialMediaUser newUser = new SocialMediaUser();
            newUser.setName(user.getName());
            newUser.setCategory(user.getCategory());
            newUser.setBio(user.getBio());
            newUser.setContactOptions(user.getContactOptions());
            newUser.setLinks(user.getLinks());
            
            // Populate the posts field
            List<SocialMediaPost> posts = new ArrayList<>();
            for (SocialMediaPost post : user.getPosts()) {
                SocialMediaPost newPost = new SocialMediaPost();
                newPost.setPlatform(post.getPlatform());
                newPost.setContent(post.getContent());
                newPost.setLikes(post.getLikes());
                newPost.setComments(post.getComments());
                newPost.setShares(post.getShares());
                newPost.setUser(newUser);
                posts.add(newPost);
            }
            newUser.setPosts(posts);
            
            users.add(newUser);
        }
        List<SocialMediaUser> saveAll = userRepository.saveAll(users);
        
        // Create analytics data for each user
        for (SocialMediaUser user : saveAll) {
            SocialMediaAnalytics analytics = new SocialMediaAnalytics();
            analytics.setUser(user);
            analytics.setFollowers(10L);
            analytics.setFollowing(20L);
            analytics.setPosts(30L);
            analytics.setAccountReached(40L);
            analytics.setAccountEngaged(60L);
            analytics.setContentShared(10L);
            analytics.setAdsRun(5L);
            analytics.setAdInsights(25L);
            analytics.setActivePromotions(13L);
            analytics.setTotalStories(100L);
            analytics.setTotalFollows(1000L);
            analytics.setTotalPosts(35L);
            analytics.setTotalSaves(15L);
            analytics.setTotalComments(2500L);
            analytics.setTotalShares(45L);
            analyticRepository.save(analytics);
        }
        
        return saveAll;

		
	}
	
	

}

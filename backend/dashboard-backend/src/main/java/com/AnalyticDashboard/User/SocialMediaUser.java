package com.AnalyticDashboard.User;

import java.util.List;

import com.AnalyticDashboard.Post.SocialMediaPost;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SocialMediaUser {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String category;
	    private String bio;
	    private String contactOptions;
	    private String links;
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<SocialMediaPost> posts;
	    
	    public SocialMediaUser() {
			super();
			// TODO Auto-generated constructor stub
		}
		public SocialMediaUser(Long id, String name, String category, String bio, String contactOptions, String links,
				List<SocialMediaPost> posts) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
			this.bio = bio;
			this.contactOptions = contactOptions;
			this.links = links;
			this.posts = posts;
		}
		
		//generate getter and setter
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public String getContactOptions() {
			return contactOptions;
		}
		public void setContactOptions(String contactOptions) {
			this.contactOptions = contactOptions;
		}
		public String getLinks() {
			return links;
		}
		public void setLinks(String links) {
			this.links = links;
		}
		public List<SocialMediaPost> getPosts() {
			return posts;
		}
		public void setPosts(List<SocialMediaPost> posts) {
			this.posts = posts;
		}

			    
	    
}

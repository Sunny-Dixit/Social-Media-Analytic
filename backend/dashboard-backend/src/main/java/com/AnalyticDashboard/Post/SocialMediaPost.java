package com.AnalyticDashboard.Post;

import com.AnalyticDashboard.User.SocialMediaUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SocialMediaPost {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String platform;
	    private String content;
	    private Long likes;
	    private Long comments;
	    private Long shares;
	    
	    @ManyToOne
	    @JsonBackReference
	    @JoinColumn(name = "user_id")
	    private SocialMediaUser user;

		public SocialMediaPost() {
			super();
			// TODO Auto-generated constructor stub
		}
		public SocialMediaPost(Long id, String platform, String content, Long likes, Long comments, Long shares,
				SocialMediaUser user) {
			super();
			this.id = id;
			this.platform = platform;
			this.content = content;
			this.likes = likes;
			this.comments = comments;
			this.shares = shares;
			this.user = user;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPlatform() {
			return platform;
		}
		public void setPlatform(String platform) {
			this.platform = platform;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Long getLikes() {
			return likes;
		}
		public void setLikes(Long likes) {
			this.likes = likes;
		}
		public Long getComments() {
			return comments;
		}
		public void setComments(Long comments) {
			this.comments = comments;
		}
		public Long getShares() {
			return shares;
		}
		public void setShares(Long shares) {
			this.shares = shares;
		}
		public SocialMediaUser getUser() {
			return user;
		}
		public void setUser(SocialMediaUser user) {
			this.user = user;
		}
			    
	    
	

}

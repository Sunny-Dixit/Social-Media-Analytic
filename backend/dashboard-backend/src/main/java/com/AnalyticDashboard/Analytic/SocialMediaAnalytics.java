package com.AnalyticDashboard.Analytic;

import com.AnalyticDashboard.User.SocialMediaUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SocialMediaAnalytics {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Long followers;
	    private Long following;
	    private Long posts;
	    private Long accountReached;
	    private Long accountEngaged;
	    private Long contentShared;
	    private Long adsRun;
	    private Long adInsights;
	    private Long activePromotions;
	    private Long totalStories;
	    private Long totalFollows;
	    private Long totalPosts;
	    private Long totalSaves;
	    private Long totalComments;
	    private Long totalShares;

	    // getters and setters
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private SocialMediaUser user;

		public SocialMediaAnalytics() {
			super();
			// TODO Auto-generated constructor stub
		}

		public SocialMediaAnalytics(Long id, Long followers, Long following, Long posts, Long accountReached,
				Long accountEngaged, Long contentShared, Long adsRun, Long adInsights, Long activePromotions,
				Long totalStories, Long totalFollows, Long totalPosts, Long totalSaves, Long totalComments,
				Long totalShares, String platform, SocialMediaUser user) {
			super();
			this.id = id;
			this.followers = followers;
			this.following = following;
			this.posts = posts;
			this.accountReached = accountReached;
			this.accountEngaged = accountEngaged;
			this.contentShared = contentShared;
			this.adsRun = adsRun;
			this.adInsights = adInsights;
			this.activePromotions = activePromotions;
			this.totalStories = totalStories;
			this.totalFollows = totalFollows;
			this.totalPosts = totalPosts;
			this.totalSaves = totalSaves;
			this.totalComments = totalComments;
			this.totalShares = totalShares;
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getFollowers() {
			return followers;
		}

		public void setFollowers(Long followers) {
			this.followers = followers;
		}

		public Long getFollowing() {
			return following;
		}

		public void setFollowing(Long following) {
			this.following = following;
		}

		public Long getPosts() {
			return posts;
		}

		public void setPosts(Long posts) {
			this.posts = posts;
		}

		public Long getAccountReached() {
			return accountReached;
		}

		public void setAccountReached(Long accountReached) {
			this.accountReached = accountReached;
		}

		public Long getAccountEngaged() {
			return accountEngaged;
		}

		public void setAccountEngaged(Long accountEngaged) {
			this.accountEngaged = accountEngaged;
		}

		public Long getContentShared() {
			return contentShared;
		}

		public void setContentShared(Long contentShared) {
			this.contentShared = contentShared;
		}

		public Long getAdsRun() {
			return adsRun;
		}

		public void setAdsRun(Long adsRun) {
			this.adsRun = adsRun;
		}

		public Long getAdInsights() {
			return adInsights;
		}

		public void setAdInsights(Long adInsights) {
			this.adInsights = adInsights;
		}

		public Long getActivePromotions() {
			return activePromotions;
		}

		public void setActivePromotions(Long activePromotions) {
			this.activePromotions = activePromotions;
		}

		public Long getTotalStories() {
			return totalStories;
		}

		public void setTotalStories(Long totalStories) {
			this.totalStories = totalStories;
		}

		public Long getTotalFollows() {
			return totalFollows;
		}

		public void setTotalFollows(Long totalFollows) {
			this.totalFollows = totalFollows;
		}

		public Long getTotalPosts() {
			return totalPosts;
		}

		public void setTotalPosts(Long totalPosts) {
			this.totalPosts = totalPosts;
		}

		public Long getTotalSaves() {
			return totalSaves;
		}

		public void setTotalSaves(Long totalSaves) {
			this.totalSaves = totalSaves;
		}

		public Long getTotalComments() {
			return totalComments;
		}

		public void setTotalComments(Long totalComments) {
			this.totalComments = totalComments;
		}

		public Long getTotalShares() {
			return totalShares;
		}

		public void setTotalShares(Long totalShares) {
			this.totalShares = totalShares;
		}



		public SocialMediaUser getUser() {
			return user;
		}

		public void setUser(SocialMediaUser user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "SocialMediaAnalytics [id=" + id + ", followers=" + followers + ", following=" + following
					+ ", posts=" + posts + ", accountReached=" + accountReached + ", accountEngaged=" + accountEngaged
					+ ", contentShared=" + contentShared + ", adsRun=" + adsRun + ", adInsights=" + adInsights
					+ ", activePromotions=" + activePromotions + ", totalStories=" + totalStories + ", totalFollows="
					+ totalFollows + ", totalPosts=" + totalPosts + ", totalSaves=" + totalSaves + ", totalComments="
					+ totalComments + ", totalShares=" + totalShares +  ", user=" + user
					+ "]";
		}
	    
	    

	
}

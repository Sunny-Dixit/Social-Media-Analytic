package com.AnalyticDashboard.Analytic;

import java.util.List;
import java.util.Optional;

import com.AnalyticDashboard.User.SocialMediaUser;

public class AnalyticResponse {
		private SocialMediaUser user;
		private List<SocialMediaAnalytics> analytics;
		
		// getters and setters
		public SocialMediaUser getUser() {
			return user;
		}
		
		public void setUser(SocialMediaUser user2) {
			this.user = user2;
		}
		
		public List<SocialMediaAnalytics> getAnalytics() {
			return analytics;
		}
		
		public void setAnalytics(List<SocialMediaAnalytics> analytics) {
			this.analytics = analytics;
		}

}

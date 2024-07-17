package com.AnalyticDashboard.Analytic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnalyticRepository extends JpaRepository<SocialMediaAnalytics,Long>{
	
	    
	    @Query("SELECT a FROM SocialMediaAnalytics a WHERE a.user.id = :userId")
	    List<SocialMediaAnalytics> findAnalyticsByUserId(@Param("userId") Long userId);
	

}

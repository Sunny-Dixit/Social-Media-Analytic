package com.AnalyticDashboard.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<SocialMediaPost,Long>{
	
	    @Query("SELECT p.user.id FROM SocialMediaPost p WHERE p.id = :postId")
	    Long findUserIdByPostId(@Param("postId") Long postId);
}


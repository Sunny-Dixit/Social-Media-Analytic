import { useState, useEffect } from "react";
import { getPosts, userAnalytics } from "../Services/Api";
import { Card, CardContent, Typography, Grid, styled, IconButton } from "@material-ui/core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChartBar, faThumbsUp, faComment, faShare } from "@fortawesome/free-solid-svg-icons";
import { Navigate, useNavigate } from "react-router-dom";


const DashboardContainer = styled("div")({
  backgroundColor: "#f5f5f5", // Add your desired background color here
  padding: 20,
  minHeight: "100vh",
});



const PostCard = styled(Card)({
  margin: 10,
  padding: 10,
  borderRadius: 10,
  boxShadow: "0px 0px 10px rgba(0,0,0,0.1)",
});

const PostPlatform = styled(Typography)({
  fontSize: 16,
  fontWeight: "bold",
});

const PostContent = styled(Typography)({
  fontSize: 14,
  padding: 10,
});

const PostActions = styled("div")({
  display: "flex",
  justifyContent: "space-between",
  padding: 10,
});

const PostActionButton = styled(IconButton)({
  padding: 5,
});

export default function Dashboard() {
  const [posts, setPosts] = useState([]);
  const navi = useNavigate(); // Add this line



  useEffect(() => {
    getPosts()
      .then(response => {
        setPosts(response.data);
        console.log(response.data); // Add this line
      })
      .catch(error => {
        console.error(error);
        // Handle the error here
      });
  }, []);

  /*const handleAnalyticClick = (post) => {
    // Add your logic here to handle the analytic click
    console.log(`Analytic click for post ${post.id}`);
    navi(`/api/analytic/${post.id}`); // Navigate to the analytics page


  };*/
  const handleAnalyticClick = (post) => {
    console.log(`Analytic click for post ${post.id}`);
    userAnalytics(post.id) // Make the API request to the backend
      .then(response => {
        // Handle the response data
        console.log(response.data);
        // Navigate to the analytics page
        navi('/analytic', { state: response.data }); // Pass the analytics data as state
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleLikeClick = (post) => {
    // Add your logic here to handle the like click
    console.log(`Like click for post ${post.id}`);
  };

  const handleCommentClick = (post) => {
    // Add your logic here to handle the comment click
    console.log(`Comment click for post ${post.id}`);
  };

  const handleShareClick = (post) => {
    // Add your logic here to handle the share click
    console.log(`Share click for post ${post.id}`);
  };

  return (
    <DashboardContainer>
      <h1>Dashboard</h1>
      <Grid container spacing={2}>
        {posts.length > 0 ? (
          posts.map((post) => (
            <Grid item key={post.id} xs={12} sm={6} md={4} lg={3}>
              <PostCard>
                <PostPlatform>{post.platform}</PostPlatform>
                <PostContent>{post.content}</PostContent>
                <PostActions>
                  <Typography variant="body2" component="p">
                    Likes: {post.likes}
                  </Typography>
                  <Typography variant="body2" component="p">
                    Comments: {post.comments}
                  </Typography>
                  <Typography variant="body2" component="p">
                    Shares: {post.shares}
                  </Typography>
                  <PostActionButton onClick={() => handleLikeClick(post)}>
                    <FontAwesomeIcon icon={faThumbsUp} />
                  </PostActionButton>
                  <PostActionButton onClick={() => handleCommentClick(post)}>
                    <FontAwesomeIcon icon={faComment} />
                  </PostActionButton>
                  <PostActionButton onClick={() => handleShareClick(post)}>
                    <FontAwesomeIcon icon={faShare} />
                  </PostActionButton>
                  <div style={{ flexGrow: 1 }} />
                </PostActions>
                <PostActionButton onClick={() => handleAnalyticClick(post)} style={{ marginTop: 10, marginBottom: 10 }}>
                  <FontAwesomeIcon icon={faChartBar} />
                  Analytics
                </PostActionButton>
              </PostCard>
            </Grid>
          ))
        ) : (
          <Grid item xs={12}>
            <Typography variant="h5" component="h2">
              No posts found
            </Typography>
          </Grid>
        )}
      </Grid>
    </DashboardContainer>
  );
}
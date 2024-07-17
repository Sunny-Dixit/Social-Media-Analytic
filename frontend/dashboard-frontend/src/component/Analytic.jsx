import { useState, useEffect } from "react";
import axios from "axios";
import { userAnalytics } from "../Services/Api";
import { useLocation } from "react-router-dom";
import './analytic.css';

const Analytic = () => {
  const [analytics, setAnalytics] = useState({}); // Initialize with an empty object
  const [user, setUser] = useState({}); // Initialize with an empty object
  const location = useLocation();

  useEffect(() => {
    if (location.state) {
      const data = location.state;
      setAnalytics(data.analytics[0] || {}); // Set default value to empty object if undefined
      setUser(data.user || {}); // Set default value to empty object if undefined
    }
  }, [location.state]);

  return (
    <div className="container">
    <h1>Analytics for Post {analytics.id}</h1>
    <section className="user-details">
      <h2>User Details</h2>
      <div className="user-card">
        <img src={user.profilePicture} alt={user.name} />
        <div className="user-info">
          <h3>{user.name}</h3>
          <p>Bio: {user.bio || 'N/A'}</p>
          <p>Category: {user.category || 'N/A'}</p>
          <p>Contact Options: {user.contactOptions || 'N/A'}</p>
          <p>ID: {user.id || 'N/A'}</p>
          <p>
            Links: 
            {user.links && (
              <a href={user.links} target="_blank" rel="noopener noreferrer">
                {user.links}
              </a>
            ) || 'N/A'}
          </p>
        </div>
      </div>
    </section>
    <section className="analytics-details">
      <h2>Analytics Details</h2>
      <div className="analytics-cards">
        <div className="card">
          <h4>Account Engaged</h4>
          <p>{analytics.accountEngaged || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.accountEngaged / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Account Reached</h4>
          <p>{analytics.accountReached || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.accountReached / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Active Promotions</h4>
          <p>{analytics.activePromotions || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.activePromotions / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Ad Insights</h4>
          <p>{analytics.adInsights || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.adInsights / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Ads Run</h4>
          <p>{analytics.adsRun || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.adsRun / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Content Shared</h4>
          <p>{analytics.contentShared || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.contentShared / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Followers</h4>
          <p>{analytics.followers || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.followers / 100}%` }}></div>
          </div>
        </div>
        <div className="card">
          <h4>Following</h4>
          <p>{analytics.following || 0}</p>
          <div className="progress-bar">
            <div className="progress" style={{ width: `${analytics.following / 100}%` }}></div>
          </div>
        </div>

        <div className="card">
            <h4>Posts</h4>
            <p>{analytics.posts || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.posts / 100}%` }}></div>
            </div>
          </div>
          <div className="card">
            <h4>Total Comments</h4>
            <p>{analytics.totalComments || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.totalComments / 100}%` }}></div>
            </div>
          </div>
          <div className="card">
            <h4>Total Follows</h4>
            <p>{analytics.totalFollows || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.totalFollows / 100}%` }}></div>
            </div>
          </div>
          <div className="card">
            <h4>Total Posts</h4>
            <p>{analytics.totalPosts || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.totalPosts / 100}%` }}></div>
            </div>
          </div>
          <div className="card">
            <h4>Total Saves</h4>
            <p>{analytics.totalSaves || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.totalSaves / 100}%` }}></div>
            </div>
          </div>
          <div className="card">
            <h4>Total Shares</h4>
            <p>{analytics.totalShares || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.totalShares / 100}%` }}></div>
            </div>
          </div>
          <div className="card">
            <h4>Total Stories</h4>
            <p>{analytics.totalStories || 0}</p>
            <div className="progress-bar">
              <div className="progress" style={{ width: `${analytics.totalStories / 100}%` }}></div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default Analytic;

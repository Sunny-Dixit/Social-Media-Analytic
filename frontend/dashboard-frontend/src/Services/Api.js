import axios from "axios";

const baseURL = "http://localhost:5050";

// User
export const getPosts = () => axios.get(`${baseURL}/posts`);

// Social media account
export const userAnalytics = (id) => axios.get(`${baseURL}/api/analytic/${id}`);


// Analytics
//export const analyticsById = (accountId) => axios.get(`${baseURL}/analytics/${accountId}`);
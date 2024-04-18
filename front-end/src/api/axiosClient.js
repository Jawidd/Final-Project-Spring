import axios from "axios";
const axiosC = axios.create({
  baseURL: "api"
});
export default axiosC;

import axios from "axios";
const axiosC = axios.create({
  baseURL: "http://localhost:3000"
});

export default {
  loginUser(user) {
    return axiosC.post("/user/login", user);
  },

  addUser(user) {
    return axiosC.post("/user/add", user);
  },

  getAllUsers() {
    return axiosC.get("/user/getall");
  },

  deleteUser(userId) {
    return axiosC.delete(`/user/${userId}/delete`);
  },

  getUser(id) {
    return axiosC.get(`/user/${id}`);
  },
  updateUser(user) {
    return axiosC.put("/user/update", user);
  },

  deleteAllUsers() {
    return axiosC.delete("/user/delete/all");
  }
};

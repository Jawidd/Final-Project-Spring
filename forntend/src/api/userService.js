import axios from "axios";
const axiosC = axios.create({
  baseURL: "/api"
});

export default {
  /*  loginUser(user) {
    return axiosC.post("/customer/login", user);
  },
 */
  addUser(user) {
    return axiosC.post("/customer/add", user);
  },

  getAllUsers() {
    return axiosC.get("/customer/getAll");
  },

  deleteUser(id) {
    return axiosC.delete(`/customer/${id}/delete`);
  },

  getUser(id) {
    return axiosC.get(`/customer/${id}/getOne`);
  },
  updateUser(user) {
    return axiosC.put("/customer/update", user);
  }

  /*  deleteAllUsers() {
    return axiosC.delete("/customer/delete/all");
  } */
};

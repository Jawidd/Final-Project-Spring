import axiosC from "./axiosClient";
export default {
  addAuthHeader(token) {
    axiosC.defaults.headers.common["Authorization"] = `Bearer ${token}`;
  },

  addUser(user) {
    return axiosC.post("/register", user);
  },

  login(user) {
    return axiosC.post("/authenticate", user);
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

import axios from "axios";
const axiosC = axios.create({
  baseURL: "/api"
});

export default {
  addType(type) {
    return axiosC.post("/type/add", type);
  },
  getAllTypes() {
    return axiosC.get("/type/getAll");
  },

  deleteType(id) {
    return axiosC.delete(`/type/${id}/delete`);
  },

  getType(id) {
    return axiosC.get(`/type/${id}/getOne`);
  },
  updateType(type) {
    return axiosC.put("/type/update", type);
  }

  /*  deleteAllTypes() {
    return axiosC.delete("/type/delete/all");
  } */
};

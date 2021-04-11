import axios from "axios";
const axiosC = axios.create({
  baseURL: "http://localhost:3000"
});

export default {


  addComment(comment1) {
    return axiosC.post("/comment/add", comment1);
  },

  getAllComments() {
    return axiosC.get("/comment/getall");
  },

  deleteComment(commentId) {
    return axiosC.delete(`/comment/${commentId}/delete`);
  },

  getComment(id) {
    return axiosC.get(`/comment/${id}`);
  },

  updateComment(comment) {
    return axiosC.put("/comment/update", comment);
  },


};

import axios from "axios";
const axiosC = axios.create({
  baseURL: "http://localhost:3000"
});

export default {
  addProduct(product) {
    return axiosC.post("/product/add", product);
  },

  getAllProducts() {
    return axiosC.get(`/product/getAll`);
  },

  updateProduct(product) {
    return axiosC.post("/product/update", product);
  },

  /* getAllproducts(type) {
    return axiosC.get(`/product/${type}/getall`);
  }, */

  deleteProduct(productId) {
    return axiosC.delete(`/product/${productId}/delete`);
  }
};

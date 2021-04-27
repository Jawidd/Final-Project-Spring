import axiosC from "./axiosClient";

export default {
  addProduct(product) {
    return axiosC.post("/product/add", product);
  },

  addProductDTO(product) {
    return axiosC.post("/productDTO/add", product);
  },
  getAllProducts() {
    return axiosC.get(`/product/getAll`);
  },

  updateProductDTO(product) {
    return axiosC.put("/productDTO/update", product);
  },

  updateProduct(product) {
    return axiosC.put("/product/update", product);
  },
  /* getAllproducts(type) {
    return axiosC.get(`/product/${type}/getall`);
  }, */

  deleteProduct(productId) {
    return axiosC.delete(`/product/${productId}/delete`);
  }
};

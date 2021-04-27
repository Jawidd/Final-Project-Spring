import Vue from "vue";
import Vuex from "vuex";
import userService from "../api/userService";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: null,
    isAdmin: false,
    productCount: 0
  },
  mutations: {
    SET_USER: (state, userData) => {
      state.user = userData;
      //localStorage.setItem("user", JSON.stringify(userData));
      userService.addAuthHeader(userData.token);
      console.log(userData.token, "sadf");
    },
    SET_ADMIN: (state, payload) => {
      state.isAdmin = payload.isAdmin;
    },
    SET_PRODUCT_COUNT: (state, payload) => {
      state.productCount = payload.productCount;
    }
  },
  actions: {
    async signup({ commit }, user) {
      const response = await userService.addUser(user);

      commit("SET_USER", response.data);
    },
    async login({ commit }, user) {
      console.log("before user service", user);
      const response = await userService.login(user);
      console.log("response:::::::   ", response.data.token);
      commit("SET_USER", response.data);
    }
  },
  modules: {}
});

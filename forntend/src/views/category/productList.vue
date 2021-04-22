<template>
  <section class="  d-flex  flex-wrap align-center grey darken-3">
    <v-hover
      v-slot="{ hover }"
      v-for="item in products"
      :key="item._id"
      class="mx-2 my-2"
    >
      <v-card :class="{ 'on-hover': hover }" max-width="400">
        <v-img
          class="white--text align-end"
          height="200px"
          :src="getImgUrl(item.img)"
        >
          <v-card-title class="h1"> {{ item.name }}</v-card-title>
        </v-img>

        <v-card-subtitle class="pb-0 "
          >Price: {{ item.price }}$
        </v-card-subtitle>

        <v-card-text class="text--primary">
          <div>{{ item.type }}</div>

          <!-- <div>Whitsunday Island, Whitsunday Islands</div> -->
        </v-card-text>

        <v-card-actions>
          <v-btn color="orange" text @click="addToCart(currentCartId, item.id)">
            Add to Cart
          </v-btn>

          <!-- <v-btn color="orange" text>
            Explore
          </v-btn> -->
        </v-card-actions>
      </v-card>
    </v-hover>
  </section>
</template>

<script>
import productListService from "../../api/productListService.js";
import cartService from "../../api/cartService.js";
export default {
  component: {},

  data() {
    return {
      type: this.$route.params.type,

      id: null,
      name: null,
      price: null,
      quantity: null,
      cartId: null,
      details: null,
      img: null,
      products: [],
      currentCartId: 14
    };
  },
  async mounted() {
    await productListService.getAllProducts().then(response => {
      this.products = response.data;
    });
    this.products = this.products.filter(element => element.type === this.type);
  },

  methods: {
    getImgUrl(pic) {
      return require("@/assets/" + pic);
    },
    addToCart(currentCartId, itemId) {
      console.log(currentCartId, "   ", itemId);
      cartService.addProductToCart(itemId).then(res => {
        console.log(res.data);

        cartService.getCart(this.currentCartId).then(response => {
          this.$store.commit("SET_PRODUCT_COUNT", {
            productCount: response.data.numberOfProducts
          });
        });

        /*  cartService.getCart(this.theId).then(response => {
      console.log(response.data);
      this.cart = response.data;
this.updateProductCount(this.cart.numberOfProducts); */
      });
      /* cartService.addProductToCart(currentCartId, itemId).then(response => {
        console.log(response.data); });*/
    }
  }
};
</script>
<style scoped>
.v-card {
  transition: opacity 0.2s ease-in-out;
}

.v-card:not() {
  opacity: 0.9;
}

.v-card:not(.on-hover) {
  opacity: 0.85;
}
.show-btns {
  color: rgba(255, 255, 255, 1) !important;
}
</style>

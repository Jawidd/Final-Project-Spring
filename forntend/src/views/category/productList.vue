<template>
  <v-container>
    <!-- 
      <div class="d-flex"> -->

    > <v-card-title>{{ type }} Category</v-card-title>

    <div class="mt-5 d-flex flex-wrap">
      <v-card
        elevation="10"
        class="ml-5 my-2 "
        max-width="344"
        outlined
        v-for="item in products"
        :key="item._id"
      >
        <v-list-item three-line>
          <v-list-item-content>
            <div class="overline mb-4">Price:{{ item.price }}</div>
            <v-list-item-title class="headline mb-1">
              {{ item.name }}
            </v-list-item-title>
            <v-list-item-subtitle
              >detail:{{ item.cartId }}</v-list-item-subtitle
            >
          </v-list-item-content>
        </v-list-item>

        <v-card-actions>
          <v-btn
            @click="deleteone(item.id)"
            outlined
            rounded
            text
            class="primary"
          >
            Buy
          </v-btn>
        </v-card-actions>
      </v-card>
    </div>
  </v-container>
</template>

<script>
import productListService from "../../api/productListService.js";

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
      products: []
    };
  },
  mounted() {
    productListService.getAllProducts().then(response => {
      this.products = response.data;
    });
  },

  methods: {
    async deleteone(id) {
      const conf = confirm("Buy This Product?");
      if (conf) {
        const res = await productListService.deleteProduct(id);
        console.log(res.data);
        (this.products = this.products.filter(book => {
          return book.id !== id;
        })),
          this.$store.commit("SET_SNACK", {
            text: "Book added to Your Cart"
          });
      }
    },
    save(date) {
      this.$refs.menu.save(date);
    },

    putOnSale() {
      const book1 = {
        name: this.name,
        detail: this.detail,
        price: this.price,
        date: this.date
      };

      const savedBook = productListService.addproduct(book1);

      console.log("UBook saved");
      console.log(savedBook);

      this.resetform();

      this.$store.commit("SET_SNACK", {
        text: "Book added For Sale"
      });

      setTimeout(() => {
        document.location.reload();
      }, 2000);
    },

    resetform() {
      this.name = null;
      this.price = null;
      this.author = null;
      this.date = null;
    }
  }
};
</script>

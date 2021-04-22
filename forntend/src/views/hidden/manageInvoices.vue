<template>
  <div>
    <v-container>
      <v-card
        dark
        style="min-width:400px;max-width:8000px;"
        outlined
        elevation="10"
      >
        <v-card-title>Add Cart(for testing...)</v-card-title>

        <v-col class="ml-1  " cols="5" sm="5" md="5">
          <v-text-field label="cart's id" outlined v-model="id"></v-text-field>
        </v-col>

        <v-btn class=" ml-auto" text color="primary" @click="addCart()"
          >Add Cart</v-btn
        >
      </v-card>
    </v-container>

    <h1 class="mx-14 my-14">Cart List</h1>
    <v-simple-table dark>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">total price</th>
            <th class="text-left">number of products</th>
            <th class="text-left">product List ids</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cart in carts" :key="cart.id">
            <td>
              <v-col><v-text-field v-model="cart.id"></v-text-field> </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="cart.total"></v-text-field> </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="cart.numberOfProducts"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="cart.productsIds"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-btn
                color="error"
                small
                class="ml-2"
                @click="deleteCart(cart.id)"
                >Delete</v-btn
              >
            </td>
          </tr>

          <v-snackbar v-model="snackbar" right>
            {{ text }}

            <template v-slot:action="{ attrs }">
              <v-btn color="pink" text v-bind="attrs" @click="snackbar = false">
                Close
              </v-btn>
            </template>
          </v-snackbar>
        </tbody>
      </template>
    </v-simple-table>

    <v-footer>
      <v-spacer></v-spacer>
      <div>&copy; {{ new Date().getFullYear() }}</div>
    </v-footer>
  </div>
</template>
<script>
import cartService from "../../api/cartService.js";
export default {
  data() {
    return {
      carts: [],
      snackbar: false,
      text: ``,
      id: null,
      total: null
    };
  },
  mounted() {
    cartService.getAllCarts().then(response => {
      this.carts = response.data;
    });
  },
  methods: {
    async addCart() {
      const Cart = {
        id: this.id
      };
      const savedprd = await cartService.addCart(Cart);
      console.log(savedprd);
      this.text = "Cart Added";
      this.snackbar = true;
      this.resetform();
      cartService.getAllCarts().then(response => {
        this.carts = response.data;
      });
    },
    async deleteCart(id) {
      const conf = confirm("Delete This?");
      if (conf) {
        const res = await cartService.deleteCart(id);
        console.log(res.data);
        this.carts = this.carts.filter(cart => {
          return cart.id !== id;
        });
        this.text = "Cart Deleted";
        this.snackbar = true;
      }
    },

    /*  async updateCart(id) {
      const cart = {
        id
      };
      const saved = await cartService.updateCart(cart);

      console.log(saved.data);
      this.text = "CArt Updated";
      this.snackbar = true;
    },  */
    resetform() {
      this.id = null;
    }
  }
};
</script>

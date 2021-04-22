<template>
  <div>
    <v-container>
      <v-card
        dark
        style="min-width:400px;max-width:8000px;"
        outlined
        elevation="10"
      >
        <v-card-title>Add Product</v-card-title>

        <v-col class="ml-1  " cols="5" sm="5" md="5">
          <v-text-field
            label="Product's Name"
            outlined
            v-model="name"
          ></v-text-field>
          <v-text-field
            label="Product's price"
            outlined
            v-model="price"
          ></v-text-field>
          <v-text-field
            label="Product's quantity"
            outlined
            v-model="quantity"
          ></v-text-field>
          <!--  -->
          <v-select
            :items="typeListNames"
            filled
            label="Product's Type"
            v-model="type"
          ></v-select>

          <v-text-field
            label="File input"
            outlined
            filled
            persistent-hint
            append-icon="mdi-camera"
            v-model="img"
            hint="Example:(spring.jpg),Picture must be Availble in Assests Folder of Project"
          ></v-text-field>
          <v-textarea
            label="Product's details"
            outlined
            v-model="details"
          ></v-textarea>
        </v-col>

        <v-btn class=" ml-auto" text color="primary" @click="putOnSale"
          >Put On Sale</v-btn
        >
      </v-card>
    </v-container>

    <h1 class="mx-14 my-14">Product List</h1>
    <v-simple-table dark>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">name</th>
            <th class="text-left">price</th>
            <th class="text-left">quantity</th>
            <th class="text-left">type</th>

            <th class="text-left">details</th>
            <th class="text-left">Img</th>
            <th class="text-left">Cart_Id</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in products" :key="item.id">
            <td>
              <v-col><v-text-field v-model="item.id"></v-text-field> </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="item.name"></v-text-field> </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="item.price"></v-text-field> </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="item.quantity"></v-text-field>
              </v-col>
            </td>
            <!-- <td>
              <v-col><v-text-field v-model="item.type"></v-text-field> </v-col>
            </td> -->

            <td>
              <v-col
                ><v-select
                  :items="typeListNames"
                  filled
                  label="Product Type"
                  v-model="item.type"
                  clearable
                ></v-select>
              </v-col>
            </td>

            <td>
              <v-col
                ><v-text-field v-model="item.details"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="item.img"></v-text-field> </v-col>
            </td>
            <td>
              <v-col>
                {{ item.cartId }}
              </v-col>
            </td>

            <td>
              <v-btn
                color="success"
                small
                class="mr-2"
                @click="
                  updateProduct(
                    item.id,
                    item.name,
                    item.price,
                    item.quantity,
                    item.type,
                    item.details,
                    item.img,
                    item.cartId
                  )
                "
                >update</v-btn
              >

              <v-btn
                color="error"
                small
                class="ml-2"
                @click="deleteProduct(item.id)"
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
import productListService from "../../api/productListService";
import typeService from "../../api/typeService.js";
export default {
  data() {
    return {
      products: [],
      snackbar: false,
      text: ``,
      name: null,
      price: null,
      quantity: null,
      type: null,
      typee: null,
      details: null,
      img: null,
      typeList: null,
      typeListNames: null
    };
  },
  mounted() {
    productListService.getAllProducts().then(response => {
      this.products = response.data;
    });

    typeService.getAllTypes().then(response => {
      this.typeList = response.data;
      this.typeListNames = this.typeList;
      for (let index = 0; index < this.typeList.length; index++) {
        const element = this.typeList[index];
        this.typeListNames[index] = element.type;
      }
      console.log(this.typeList);
    });
  },
  methods: {
    async putOnSale() {
      const product = {
        name: this.name,
        price: this.price,
        quantity: this.quantity,
        type: this.type,
        details: this.details,
        img: this.img
      };
      const savedprd = await productListService.addProductDTO(product);
      console.log(savedprd);
      this.text = "Prouduct Added";
      this.snackbar = true;
      this.resetform();
      productListService.getAllProducts().then(response => {
        this.products = response.data;
      });
    },
    async deleteProduct(id) {
      const conf = confirm("Delete This?");
      if (conf) {
        const res = await productListService.deleteProduct(id);
        console.log(res.data);
        this.products = this.products.filter(prd => {
          return prd.id !== id;
        });
        this.text = "product Deleted";
        this.snackbar = true;
      }
    },

    async updateProduct(id, name, price, quantity, type, details, img) {
      const product = {
        id,
        name,
        price,
        quantity,
        type,
        details,
        img
      };
      console.log(product);
      const savedPrd = await productListService.updateProductDTO(product);

      console.log(savedPrd.data);
      this.text = "product Updated";
      this.snackbar = true;
    },
    resetform() {
      (this.name = null),
        (this.price = null),
        (this.quantity = null),
        (this.type = null),
        (this.details = null),
        (this.img = null);
    }
  }
};
</script>

<template>
  <div>
    <v-container>
      <v-card
        dark
        style="min-width:400px;max-width:8000px;"
        outlined
        elevation="10"
      >
        <v-card-title>Add Category</v-card-title>

        <v-col class="ml-1  " cols="5" sm="5" md="5">
          <v-text-field
            label="Category's Name"
            outlined
            v-model="type"
          ></v-text-field>

          <v-text-field
            label="Category's Img"
            outlined
            filled
            persistent-hint
            append-icon="mdi-camera"
            v-model="img"
            hint="Example:(spring.jpg),Picture must be Availble in Assests Folder of Project"
          ></v-text-field>
        </v-col>

        <v-btn class=" ml-auto" text color="primary" @click="addCategory()"
          >Add Category</v-btn
        >
      </v-card>
    </v-container>

    <h1 class="mx-14 my-14">Category List</h1>
    <v-simple-table dark>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">Img</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in types" :key="item.type">
            <td>
              <v-col><v-text-field v-model="item.type"></v-text-field> </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="item.img"></v-text-field> </v-col>
            </td>
            <td>
              <v-btn
                color="success"
                small
                class="mr-2"
                @click="updateCategory(item.type, item.img)"
                >update</v-btn
              >

              <v-btn
                color="error"
                small
                class="ml-2"
                @click="deleteCategory(item.type)"
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

import typeService from "../../api/typeService.js";
export default {
  data() {
    return {
      types: [],
      snackbar: false,
      text: ``,
      type: null,
      img: null
      /*   typeList: null,
      typeListNames: null  */
    };
  },
  mounted() {
    typeService.getAllTypes().then(response => {
      this.types = response.data;
    });
  },
  methods: {
    async addCategory() {
      const Type = {
        type: this.type,
        img: this.img
      };
      const savedprd = await typeService.addType(Type);
      console.log(savedprd);
      this.text = "Category Added";
      this.snackbar = true;
      this.resetform();
      typeService.getAllTypes().then(response => {
        this.types = response.data;
      });
    },
    async deleteCategory(id) {
      const conf = confirm("Delete This?");
      if (conf) {
        const res = await typeService.deleteType(id);
        console.log(res.data);
        this.types = this.types.filter(type => {
          return type.id !== id;
        });
        this.text = "Category Deleted";
        this.snackbar = true;
      }
    },

    async updateCategory(type, img) {
      const Type = {
        type,
        img
      };
      const savedPrd = await typeService.updateType(Type);

      console.log(savedPrd.data);
      this.text = "Category Updated";
      this.snackbar = true;
    },
    resetform() {
      (this.type = null), (this.img = null);
    }
  }
};
</script>

<template>
  <div>
    <v-container>
      <v-card
        dark
        style="min-width:400px;max-width:8000px;"
        outlined
        elevation="10"
      >
        <v-card-title>Add Admin/Customer</v-card-title>

        <v-col class="ml-1  " cols="5" sm="5" md="5">
          <v-text-field
            label="User's Name"
            outlined
            v-model="name"
          ></v-text-field>
          <v-text-field
            label="User's lastName"
            outlined
            v-model="lastName"
          ></v-text-field>
          <v-text-field
            label="USer's dateOfBirth"
            outlined
            v-model="dateOfBirth"
          ></v-text-field>
          <v-text-field
            label="User's email"
            outlined
            v-model="email"
          ></v-text-field>
          <v-text-field
            label="User's password"
            outlined
            v-model="password"
          ></v-text-field>
          <v-text-field
            label="User's location"
            outlined
            v-model="location"
          ></v-text-field>

          <v-checkbox
            v-model="checkbox"
            :label="`Is Admin: ${checkbox.toString()}`"
          ></v-checkbox>
        </v-col>

        <v-btn class=" ml-auto" text color="primary" @click="addUser()"
          >Add User</v-btn
        >
      </v-card>
    </v-container>
    <!--  -->
    <!--  -->

    <!--  -->
    <!--  -->
    <h1 class="mx-14 my-14">User List</h1>
    <v-simple-table dark>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">name</th>
            <th class="text-left">lastName</th>
            <th class="text-left">DateOfBirth</th>
            <th class="text-left">Email</th>
            <th class="text-left">password</th>
            <th class="text-left">Location</th>
            <th class="text-left">isAdmin</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" :key="user.id">
            <td>
              <v-col><v-text-field v-model="user.id"></v-text-field> </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="user.name"></v-text-field> </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="user.lastName"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="user.dateOfBirth"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-col><v-text-field v-model="user.email"></v-text-field> </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="user.password"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-col
                ><v-text-field v-model="user.location"></v-text-field>
              </v-col>
            </td>
            <td>
              <v-col>
                <v-checkbox
                  v-model="user.admin"
                  :label="`Is Admin: ${user.admin.toString()}`"
                ></v-checkbox>
              </v-col>
            </td>

            <td>
              <v-btn
                color="success"
                small
                class="mr-2"
                @click="
                  updateUser(
                    user.id,
                    user.name,
                    user.lastName,
                    user.dateOfBirth,
                    user.email,
                    user.password,
                    user.location,
                    user.admin
                  )
                "
                >update</v-btn
              >

              <v-btn
                color="error"
                small
                class="ml-2"
                @click="deleteUser(user.id)"
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

    <!-- <v-btn color="error" small class="ml-2" @click="deleteAllcars()"
      >Delete All</v-btn
    > -->
  </div>
</template>
<script>
import userService from "../../api/userService.js";

export default {
  data() {
    return {
      checkbox: false,
      users: [],
      snackbar: false,
      text: ``,
      name: null,
      lastName: null,
      dateOfBirth: null,
      email: null,
      password: null,
      location: null,
      admin: false
    };
  },
  mounted() {
    userService.getAllUsers().then(response => {
      this.users = response.data;
    });
  },
  methods: {
    async addUser() {
      const user = {
        name: this.name,
        lastName: this.lastName,
        dateOfBirth: this.dateOfBirth,
        email: this.email,
        password: this.password,
        location: this.location,
        admin: this.admin
      };
      const savedUser = await userService.addUser(user);
      console.log("user saved");
      console.log(savedUser);
      this.text = "User Addedd";
      this.snackbar = true;
      this.resetform();
      userService.getAllUsers().then(response => {
        this.users = response.data;
      });
    },
    async deleteUser(id) {
      const conf = confirm("Delete This?");
      if (conf) {
        const res = await userService.deleteUser(id);
        console.log(res.data);
        this.users = this.users.filter(user => {
          return user.id !== id;
        });
        this.text = "User Deleted";
        this.snackbar = true;
      }
    },

    async updateUser(
      id,
      name,
      lastName,
      dateOfBirth,
      email,
      password,
      location,
      admin
    ) {
      const user = {
        id,
        name,
        lastName,
        dateOfBirth,
        email,
        password,
        location,
        admin
      };
      console.log(user);
      const saveduser = await userService.updateUser(user);

      console.log(saveduser.data);
      this.text = "User Updated";
      this.snackbar = true;
    },
    resetform() {
      (this.name = null),
        (this.lastName = null),
        (this.dateOfBirth = null),
        (this.email = null),
        (this.password = null),
        (this.location = null),
        (this.admin = false);
    }
  }
};
</script>

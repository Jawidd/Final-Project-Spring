<template>
  <!--  <v-theme-provider dark> -->
  <section id="account">
    <base-section-heading
      color="grey lighten-2"
      icon="mdi-vuetify"
      title="Login /Signup"
      class="mt-15"
    />
    <!--  -->
    <!--  -->
    <!--  -->
    <v-container>
      <v-card max-width="500px" class="mx-auto">
        <!--    <v-tabs class="mx-auto" color="deep-purple accent-4"> -->
        <v-tabs background-color="blue accent-3" centered color="black">
          <v-tab> <v-icon>mdi-account</v-icon>Login</v-tab>
          <v-tab><v-icon>mdi-account-box</v-icon>Signup</v-tab>

          <v-tab-item>
            <v-card dark>
              <v-form v-model="valid" dark>
                <v-container>
                  <v-row>
                    <v-col cols="10" sm="11" md="11" class="ml-6">
                      <v-text-field
                        v-model="email"
                        :rules="emailRules"
                        label="E-mail"
                        required
                      ></v-text-field>

                      <v-text-field
                        v-model="password"
                        :rules="passwordRules"
                        :counter="8"
                        label="Password"
                        required
                      ></v-text-field>

                      <v-btn class="" color="secondary" @click="login()"
                        >Login</v-btn
                      >
                    </v-col>
                  </v-row>
                </v-container>
              </v-form>
            </v-card>
          </v-tab-item>
          <!--Sign up  ---------------------------------------------->
          <!--  ----------------------------------------------------->
          <v-tab-item>
            <v-card dark>
              <v-form v-model="valid" dark>
                <v-container>
                  <v-row>
                    <v-col cols="10" sm="11" md="11" class="ml-6">
                      <v-text-field
                        label="Name"
                        v-model="name"
                        required
                      ></v-text-field>
                      <v-text-field
                        label="lastName"
                        v-model="lastName"
                        required
                      ></v-text-field>
                      <v-text-field
                        v-model="email"
                        :rules="emailRules"
                        label="E-mail"
                        required
                      ></v-text-field>

                      <v-text-field
                        v-model="password"
                        :rules="passwordRules"
                        :counter="8"
                        label="Password"
                        required
                      ></v-text-field>
                      <v-menu
                        ref="menu"
                        v-model="menu"
                        :close-on-content-click="false"
                        transition="scale-transition"
                        offset-y
                        min-width="290px"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            v-model="date"
                            label="Date Of Birth"
                            append-icon="mdi-calendar"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                          ></v-text-field>
                        </template>
                        <v-date-picker
                          ref="picker"
                          v-model="date"
                          :max="new Date().toISOString().substr(0, 10)"
                          min="1950-01-01"
                          @change="save"
                        ></v-date-picker
                      ></v-menu>

                      <v-text-field
                        label="location"
                        v-model="location"
                      ></v-text-field>

                      <v-btn
                        class=" ml-auto"
                        color="secondary"
                        @click="signup()"
                        >Sign up</v-btn
                      >
                    </v-col>
                  </v-row>
                </v-container>
              </v-form>
            </v-card>
          </v-tab-item>
        </v-tabs>
      </v-card>
    </v-container>

    <!--  -->
    <!--  -->
    <!--    <v-checkbox
      v-model="admin"
      :label="`Is Admin? ${admin.toString()}`"
      @click="toggleAdmin()"
    ></v-checkbox>
    <h2>is Admin?{{ admin }}</h2> -->
  </section>
  <!--   </v-theme-provider> -->
</template>

<script>
import userService from "../../api/userService.js";
export default {
  mounted() {
    userService.getAllUsers().then(response => {
      this.users = response.data;
      console.log(this.users, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    });
  },
  data: () => ({
    name: null,
    lastName: null,
    dateOfBirth: null,
    email: "",
    password: "",
    location: null,
    date: null,
    menu: false,
    username: "",
    tab: 0,
    valid: true,
    passwordRules: [
      v => !!v || "Password is required",
      v => (v && v.length >= 8) || "Password must be more than 7 characters",
      v => (v && v.length <= 20) || "Password must be less than 20 characters"
    ],
    nameRules: [
      v => !!v || "Name is required",
      v => (v && v.length <= 15) || "Name must be less than 15 characters"
    ],
    lastNameRules: [
      v => !!v || "Last Name is required",
      v => (v && v.length >= 8) || "Last Name must be less than 15 characters"
    ],
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ],
    checkbox: false
  }),
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    }
  },
  methods: {
    signup() {
      const user = {
        name: this.name,
        lastName: this.lastName,
        dateOfBirth: this.dateOfBirth,
        email: this.email,
        password: this.password,
        location: this.location
      };
      const savedUser = userService.addUser(user);
      console.log("user saved");
      console.log(savedUser);
      this.text = "Signed up";
      this.snackbar = true;
      this.resetform();
    },
    //Not Complete
    login() {
      this.$store.commit("SET_ADMIN", { isAdmin: true });
    },
    save(date) {
      this.$refs.menu.save(date);
    }
    /*  validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    } */
  }
};
</script>

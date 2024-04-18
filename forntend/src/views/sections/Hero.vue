<template>
  <section id="hero">
    <!--  <v-parallax src="@/assets/material.jpg"></v-parallax> -->

    <v-container class="pa-4 text-center">
      <v-row class="fill-height" align="center" justify="center">
        <template v-for="item in typeList">
          <v-col :key="item.type" cols="12" md="4">
            <v-hover v-slot="{ hover }">
              <v-card
                :to="`/category/${item.type}/productList`"
                :elevation="hover ? 12 : 2"
                :class="{ 'on-hover': hover }"
              >
                <v-img :src="getImgUrl(item.img)" height="225px">
                  <v-card-title class="title white--text">
                    <v-row
                      class="fill-height flex-column"
                      justify="space-between"
                    >
                      <p class="mt-5 ml-10 subheading text-left">
                        {{ item.type }}
                      </p>

                      <div class="align-self-center">
                        <v-icon
                          :class="{ 'show-btns': hover }"
                          color="transparent"
                        >
                          <!--   {{ icon }} -->
                        </v-icon>
                      </div>
                    </v-row>
                  </v-card-title>
                </v-img>
              </v-card>
            </v-hover>
          </v-col>
        </template>
      </v-row>
    </v-container>
  </section>
</template>

<script>
import typeService from "../../api/typeService.js";

export default {
  name: "SectionHero",

  provide: {
    theme: { isDark: true }
  },
  methods: {
    getImgUrl(pic) {
      return require("@/assets/" + pic);
    }
  },
  async mounted() {
    await typeService.getAllTypes().then(response => {
      this.typeList = response.data;
      console.log(this.typeList);
    });
  },

  data: () => ({
    typeList: null,

    transparent: "rgba(255, 255, 255, 0)"
  }),

  computed: {
    minHeight() {
      const height = this.$vuetify.breakpoint.mdAndUp ? "100vh" : "50vh";

      return `calc(${height} - ${this.$vuetify.application.top}px)`;
    }
  }
};
</script>
<style scoped>
.v-card {
  transition: opacity 0.4s ease-in-out;
}

.v-card:not(.on-hover) {
  opacity: 0.6;
}

.show-btns {
  color: rgba(255, 255, 255, 1) !important;
}
</style>

<template>
  <base-section id="about-our-product">
    <base-section-heading
      color="grey lighten-2"
      icon="mdi-vuetify"
      title="About our Product"
    />

    <v-container>
      <v-row>
        <v-col v-for="card in cards" :key="card.title" cols="12" md="4">
          <base-info-card v-bind="card" />
        </v-col>
      </v-row>
    </v-container>
  </base-section>
</template>

<script>
export default {
  name: "SectionAboutOurProduct",

  data: () => ({
    cards: [
      {
        title: "Grow your Revenue",
        subtitle: "Best Productivity",
        text:
          "It's not always that we need to find more but rather that we need to find the best.",
        callout: "01"
      },
      {
        title: "Affordable Prices",
        subtitle: "Special Offers",
        text:
          "Whoever said that money cant buy happiness simply didn`t know where to go shopping.",
        callout: "02"
      },
      {
        title: "Target Setting",
        subtitle: "Income Flow",
        text:
          "Don`t downgrade your dream to match your reality upgrade your faith to match your destiny.",
        callout: "03"
      }
    ]
  })
};
</script>

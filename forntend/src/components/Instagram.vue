<template>
  <base-info-card title="Follow On Instagram">
    <v-row dense>
      <v-col v-for="n in 6" :key="n" cols="auto">
        <base-img
          :src="require(`@/assets/ins-${n}.jpg`)"
          color="grey lighten-1"
          width="100"
          tile
        />
      </v-col>
    </v-row>
  </base-info-card>
</template>

<script>
export default {
  name: "Instagram"
};
</script>

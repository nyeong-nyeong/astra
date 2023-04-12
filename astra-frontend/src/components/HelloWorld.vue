<template>
  <v-container fluid>
    <v-tabs
      v-model="tab"
      color="deep-white-accent-4"
      align-tabs="center"
    >
      <v-tab :value="1">Landscape</v-tab>
      <v-tab :value="2">City</v-tab>
      <v-tab :value="3">Abstract</v-tab>
    </v-tabs>
  <v-card 
  max-auto="mx-auto"
  max-width="100%"
  style="padding:2% 3% 0% 5%"
  >
    <v-window v-model="tab">
      <v-window-item
        v-for="n in 3"
        :key="n"
        :value="n"
      >
          <v-row dense>
            <v-col
              v-for="i in 6"
              :key="i"
              cols="12"
              md="3"
            >
              <v-img
                :src="`https://picsum.photos/500/300?image=${i * n * 5 + 10}`"
                :lazy-src="`https://picsum.photos/10/6?image=${i * n * 5 + 10}`"
                aspect-ratio="1"
              ></v-img>
            </v-col>
          </v-row>
        
      </v-window-item>
    </v-window>
  </v-card>
</v-container>
</template>

<script lang="ts">
  export default {
    data: () => ({
      tab: null,
    }),
  }
</script>
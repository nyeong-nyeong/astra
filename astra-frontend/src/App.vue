<template>
  <v-app>
    <v-app-bar app color="primary" dark>
    <v-app-bar-nav-icon></v-app-bar-nav-icon>
    <v-tool-bar-title>Astra-jong</v-tool-bar-title>
    <v-spacer></v-spacer>
    <v-btn icon><v-icon>mdi-magnify</v-icon></v-btn>
    </v-app-bar>
    <v-main>
      <HelloWorld/>
    </v-main>
    <v-footer color="primary">
    </v-footer>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import HelloWorld from './components/HelloWorld.vue'

export default defineComponent({
  name: 'App',

  components: {
    HelloWorld,
  },

  data () {
    return {
      //
    }
  },
})
</script>

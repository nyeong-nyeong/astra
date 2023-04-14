<template>
  <v-app>
    <v-app-bar app dark>
    <v-spacer @click="toHome"><h2 style="cursor: pointer; text-align:center ;">Astra</h2></v-spacer>
    </v-app-bar>    
    <v-main>      
      <left-nav-bar>
        <template v-slot:nav>
          <router-view/>          
           <!-- <login-page/> -->
        </template>
    </left-nav-bar>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import LeftNavBar from './components/LeftNavBar.vue'
import { router } from './router'

export default defineComponent({
  name: 'App',

  components: {
    LeftNavBar,
  },

  data () {
    return {
    }
  },
  methods: {
    toHome() {
      router.push('/')
    }
  }
})
</script>

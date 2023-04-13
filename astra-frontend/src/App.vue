<template>
  <v-app>
    <v-app-bar app dark>
    <v-spacer><h2 style="text-align:center">Astra</h2></v-spacer>
    </v-app-bar>    
    <v-main>      
      <left-nav-bar>
        <template v-slot:nav>
          <!-- <roter-view/>
           -->
           <login-page/>
        </template>
    </left-nav-bar>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
// import HelloWorld from './components/HelloWorld.vue'
import LoginPage from './components/LoginPage.vue'
import LeftNavBar from './components/LeftNavBar.vue'

export default defineComponent({
  name: 'App',

  components: {
    // HelloWorld,
    LoginPage,
    LeftNavBar,
  },

  data () {
    return {
    }
  },
})
</script>

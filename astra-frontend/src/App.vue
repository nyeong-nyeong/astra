<template>
  <v-app>
    <v-app-bar app dark>
    <v-spacer @click="toHome"><h2 style="cursor: pointer; text-align:center ;">Astra</h2></v-spacer>
    </v-app-bar>    
    <v-main>      
      <left-nav-bar>
        <template v-slot:nav>
          <router-view/>          
        </template>
    </left-nav-bar>
    </v-main>
  </v-app>
</template>

<script lang="ts" setup>
import LeftNavBar from './components/LeftNavBar.vue'
import { router } from './router'



const toHome = () => {
  router.push('/');
}
  

</script>

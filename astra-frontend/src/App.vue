<template>
  <v-app>
    <v-app-bar app dark>
    <v-spacer><h2 style="text-align:center">Astra</h2></v-spacer>
    </v-app-bar>
    <v-if>
    <v-main>
      <LeftNavBar>
        <template v-slot:nav>
          <HelloWorld/>
        </template>
    </LeftNavBar>
    </v-main>
  </v-if>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import HelloWorld from './components/HelloWorld.vue'
import LeftNavBar from './components/LeftNavBar.vue'

export default defineComponent({
  name: 'App',

  components: {
    HelloWorld,
    LeftNavBar,
  },

  data () {
    return {
      //
    }
  },
})
</script>

<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer v-model="drawer" :rail="rail" permanent @click="rail = false">
        <v-list-item v-show="isLogin" prepend-avatar="https://randomuser.me/api/portraits/men/85.jpg" title="John Leider"
          nav>
          <template v-slot:append>
            <v-btn variant="text" icon="mdi-chevron-left" @click.stop="rail = !rail"></v-btn>
          </template>
        </v-list-item>
        <v-list-item v-show="!isLogin"
          prepend-avatar="https://thumbs.dreamstime.com/z/default-avatar-profile-icon-vector-unknown-social-media-user-photo-default-avatar-profile-icon-vector-unknown-social-media-user-184816085.jpg"
          title="s" nav>
          <template v-slot:append>
            <v-btn variant="text" icon="mdi-chevron-left" @click.stop="rail = !rail"></v-btn>
          </template>
        </v-list-item>
        <v-divider></v-divider>

        <v-list density="compact" nav>
          <v-list-item v-show="isLogin" prepend-icon="mdi-account" title="My Account" value="account"></v-list-item>                    
          <v-list-item v-show="!isLogin" prepend-icon="mdi-login" title="login" value="account1"
            @click="login"></v-list-item>
          <v-list-item v-show="isLogin" prepend-icon="mdi-logout" title="logout" value="account"></v-list-item>
          <v-list-item prepend-icon="mdi-home-city" title="Home" value="home" @click="home"></v-list-item>
          <v-list-item prepend-icon="mdi-account-group-outline" title="Users" value="users"></v-list-item>
        </v-list>
      </v-navigation-drawer>
      <slot name="nav"></slot>
    </v-layout>
  </v-card>
</template>

<script lang="ts" setup>
import { router } from '@/router';
import { onMounted } from 'vue';
import { ref , watchEffect} from 'vue';

const rail = ref<boolean>(true);
const drawer = ref<boolean>(true);
const isLogin = ref<boolean>(false);
// const id = ref<any>(sessionStorage.getItem('id'));


onMounted(() => {})
const login = () => {
  if (rail.value == false) {
    router.push("/login")
  }
}

const home = () =>{
  console.log(sessionStorage.getItem('id'));
}

watchEffect(() => {

});
</script>
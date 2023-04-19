<template>
  <v-container fluid color="blue-grey lighten-4">
    <v-flex xs1>
      <v-card>
        <div class="pa-9 login-main">
          <div>
            <v-form style="padding: 0% 14% 10% 14%;" class="h-75" @submit.prevent>
              <v-img :width="550" src="../../public/4957136.jpg" aspect-ratio="16/9" cover>

              </v-img>
              <h1 style="text-align: center" class="mb-10">Sign in</h1>
              <v-text-field v-model="userData.id" :rules="rules" label="ID"
                prepend-inner-icon="mdi-account"></v-text-field>
              <v-text-field v-model="userData.password" prepend-inner-icon="mdi-lock" type="password" label="Password">
              </v-text-field>
              <v-checkbox label="Remember me"></v-checkbox>
              <v-btn @click="login" color="blue lighten-1 text-capitalize" depressed large block dark class="mb-3">
                Login
              </v-btn>
              <v-btn @click="findUser" color="blue lighten-1 text-capitalize" depressed large block dark>
                forgot your Password || Id ?
              </v-btn>
            </v-form>
          </div>
          <div>
            <form style="padding-top: 15%;">
              <v-img :width="530" src="../../public/team.png" aspect-ratio="16/9" cover>

              </v-img>
              <h1 style="text-align: center" class="mb-10">join us ?</h1>
              <h3 style="text-align: center" class="mb-1">You don't have an account ?</h3>
              <h3 style="text-align: center" class="mb-8">Please Sign Up from here</h3>
              <v-btn @click="join" block>
                Sign Up
              </v-btn>
            </form>
          </div>

        </div>
      </v-card>
    </v-flex>
  </v-container>
</template>
  
<script lang="ts" setup>
import { ref } from 'vue';
import axios from "../http";
import { router } from '@/router';

interface User {
  id?: string,
  password?: string
}
const userData = ref<User>({});
const login = () => {
  if (userData.value.id == '' || !userData.value.id) {
    window.alert('Please enter a user Id.')
    return;
  } else if (userData.value.password == '' || !userData.value.password) {
    window.alert('Please enter a user PassWord.')
    return;
  }
  axios.get(`/api/users/${userData.value.password}?id=${userData.value.id}`).then((response: any) => {
    const data = response.data;
    if (data == 'No Such Id') {
      return window.alert(data);
    } else if (data == 'wrong password') {
      return window.alert('wrong password')
    } window.alert('success')
  })
}
const join = () => {
  router.push('join')
}
</script>
<style scoped>
.login-main {
  display: flex;  
  justify-content: center;
  align-items: center;
}
</style>
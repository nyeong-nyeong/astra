<template>
    <v-container fluid color="blue-grey lighten-4">
        <v-flex xs1>
            <v-card style="padding: 0% 35% 0% 23%;">
                <div class="pa-9 login-main">
                    <form style="padding-top: 0%;">
                        <v-img :width="530" src="../../public/team.png" aspect-ratio="16/9" cover>
                        </v-img>
                        <h1 style="text-align: center" class="mb-10">Welcome !</h1>
                        <h3 style="text-align: center" class="mb-1">You don't have an account ?</h3>
                        <h3 style="text-align: center" class="mb-8">Please Sign Up from here</h3>
                        <div>
                            <v-text-field v-model="userData.name" label="Name"
                                    prepend-inner-icon="mdi-pencil"></v-text-field>
                            
                            <v-text-field v-model="userData.id" label="Id" prepend-inner-icon="mdi-account">
                         </v-text-field>                         
                         <v-btn color="gray">
                            <p>Confirm Id Duplication</p>
                            </v-btn>
                        </div>
                    </form>
                    <div>

                        <div>
                            <vue-daum-postcode @complete="oncomplete"/>
                            <v-form style="padding: 10% 14% 10% 14%;" class="h-75">
                                <v-img :width="550" aspect-ratio="16/9" cover></v-img>                                
                                <v-text-field v-model="userData.password" prepend-inner-icon="mdi-lock" type="password"
                                    label="Password">
                                </v-text-field>
                                <v-text-field v-model="userData.id" prepend-inner-icon="mdi-lock" type="password"
                                    label="Password Check">
                                </v-text-field>
                                <div v-show="match"><span style="color:red">{{ "not matches password." }}</span></div>
                                <v-text-field v-model="userData.id" label="Address"
                                    prepend-inner-icon="mdi-home"
                                    @click="search"
                                    ></v-text-field>
                                    <v-text-field v-model="userData.id" label="Detail Address"
                                    prepend-inner-icon="mdi-home"></v-text-field>
                                <v-text-field v-model="userData.email" label="Email"
                                    prepend-inner-icon="mdi-email"></v-text-field>
                                <v-select v-model="userData.gender" :items="gender" label="Gender"
                                    prepend-inner-icon="mdi-pencil"></v-select>
                                <v-select v-model="userData.gender" :items="gender" label="BirthDay"
                                    prepend-inner-icon="mdi-cake"></v-select>
                                <v-text-field v-model="userData.gender" label="Phone Number"
                                    prepend-inner-icon="mdi-phone"></v-text-field>
                                <v-btn @click="login" color="warning" depressed large block dark class="mb-3">
                                    Validate
                                </v-btn>
                                <v-btn @click="findUser" color="success" depressed large block dark>
                                    Submit
                                </v-btn>
                            </v-form>
                        </div>
                    </div>

                </div>
            </v-card>
        </v-flex>
    </v-container>
</template>
    
<script lang="ts" setup>
import { ref } from 'vue';
import axios from "../http";
import { VueDaumPostcode } from 'vue-daum-postcode';

interface User {
    id?: string,
    password?: string
}
const gender: any = ["male", "female"];
const match: boolean = false;
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
        } window.alert('sucwcess')
    })
}

const oncomplete = (data:any) => {    
    console.log(data);
}
</script>
<style scoped>
.login-main {
    display: flex;
}
</style>
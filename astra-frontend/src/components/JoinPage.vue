<template>
    <v-container fluid color="blue-grey lighten-4">
        <v-flex xs1>
            <v-card>
                <div class="pa-9 login-main">
                    <div>
                        <form style="padding-top: 0%;">
                            <v-img :width="530" src="../../public/team.png" aspect-ratio="16/9" cover>
                            </v-img>
                            <h1 style="text-align: center" class="mb-10">Welcome !</h1>
                            <h3 style="text-align: center" class="mb-1">You don't have an account ?</h3>
                            <h3 style="text-align: center" class="mb-8">Please Sign Up from here</h3>
                            <div>
                                <v-text-field v-model="userData.name" label="NickName"
                                    prepend-inner-icon="mdi-pencil"></v-text-field>
                                <v-text-field v-model="userData.id" label="Id" prepend-inner-icon="mdi-account">
                                </v-text-field>
                                <v-btn color="gray" @click="ceheckIdDulicated">
                                    <p>Confirm Id Duplication</p>
                                </v-btn>
                            </div>
                        </form>
                    </div>

                    <div>
                        <v-form style="padding: 10% 14% 10% 14%;" class="h-75">
                            <v-img :width="550" aspect-ratio="16/9" cover></v-img>
                            <v-text-field v-model="userData.password" prepend-inner-icon="mdi-lock" type="password"
                                label="Password">
                            </v-text-field>
                            <v-text-field v-model="passwordCheck" prepend-inner-icon="mdi-lock" type="password"
                                label="Password Check">
                            </v-text-field>
                            <div v-show="match"><span style="color:red">{{ "not matches password." }}</span></div>
                            <v-text-field v-model="userData.address" label="Address" prepend-inner-icon="mdi-home"
                                @click="search" :readonly="true">
                                <template>
                                    <v-row justify="center">
                                        <v-dialog v-model="dialog" width="800">
                                            <template v-slot:activator="{ props }">
                                                <v-btn color="primary" v-bind="props">
                                                    Open Dialog
                                                </v-btn>
                                            </template>
                                            <v-card>
                                                <v-card-text>
                                                    <vue-daum-postcode @complete="oncomplete" />
                                                </v-card-text>
                                                <v-card-actions>
                                                    <v-spacer></v-spacer>
                                                    <v-btn color="green-darken-1" variant="text" @click="dialog = false">
                                                        Close
                                                    </v-btn>
                                                </v-card-actions>
                                            </v-card>
                                        </v-dialog>
                                    </v-row>
                                </template>
                            </v-text-field>
                            <v-text-field v-model="detailAddress" label="Detail Address"
                                prepend-inner-icon="mdi-home"></v-text-field>
                            <v-text-field v-model="email" label="Email"
                                prepend-inner-icon="mdi-email"></v-text-field>
                            <v-select v-model="userData.gender" :items="gender" label="Gender"
                                prepend-inner-icon="mdi-pencil"></v-select>
                            <v-text-field v-model="userData.birthday" :items="gender" label="BirthDay"
                                prepend-inner-icon="mdi-cake">
                                <VueDatePicker v-model="userData.birthday"></VueDatePicker>
                            </v-text-field>
                            <v-text-field v-model="userData.phoneNumber" label="Phone Number"
                                prepend-inner-icon="mdi-phone"></v-text-field>
                            <v-btn @click="chheckRegist" color="warning" depressed large block dark class="mb-3">
                                Validate
                            </v-btn>
                            <v-btn @click="regist" color="success" depressed large block dark>
                                Submit
                            </v-btn>
                        </v-form>
                    </div>
                </div>
            </v-card>
        </v-flex>
    </v-container>
</template>
    
<script lang="ts" setup>
import { ref, watchEffect } from 'vue';
import axios from "../http";
import { VueDaumPostcode } from 'vue-daum-postcode';
import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'


interface User {
    id: string,
    password: string
    name: string
    address: string
    sEmail: string
    fEamil: string
    gender: String
    phoneNumber: string
    birthday: Date 
    age: number
}
let email = "";
const passwordCheck = ref("");
const gender: any = ["male", "female"];
const match: boolean = false;
const userData = ref<User>({});
const detailAddress = ref("");
const dialog = ref(false);
const date = ref(Date);
const chheckRegist = () => {
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
const ceheckIdDulicated = () => {
    axios.get(`/api/users/checkId?id=${userData.value.id}`).then((response: any) => {    
        if(response.data == 'OK'){
            alert('Id avaliable')
        } else {
            alert('Id aleady exist')
            userData.value.id = "";
        }
    })
}
const regist = () => {
    console.log(email);
}

const oncomplete = (data: any) => {
    console.log(data.address);
    userData.value.address = data.address;
    dialog.value = false;
}

const search = () => {
    dialog.value = true;
}

watchEffect(() => {
    console.log(dialog.value);
})

watchEffect(() => {
    console.log(date.value);
})
</script>
<style scoped>
.login-main {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
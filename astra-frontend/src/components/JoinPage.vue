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
                            <v-text-field v-model="userData.pw" prepend-inner-icon="mdi-lock" type="password"
                                label="Password">
                            </v-text-field>
                            <v-text-field v-model="passwordCheck" prepend-inner-icon="mdi-lock" type="password"
                                label="Password Check">
                            </v-text-field>
                            <div v-show="userData.pw != passwordCheck">                                
                                <span style="color:red">{{ "not matchespassword." }}</span></div>
                            <v-text-field v-model="userData.address" label="Address" prepend-inner-icon="mdi-home"
                                @click="search" :readonly="true">
                                <template>
                                    <v-row justify="center">
                                        <v-dialog v-model="dialog" width="800">
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

                            <v-text-field v-model="userData.email" label="Email"
                                prepend-inner-icon="mdi-email"></v-text-field>

                            <v-select v-model="userData.gender" :items="gender" label="Gender"
                                prepend-inner-icon="mdi-pencil"></v-select>

                            <v-text-field v-model="userData.birthday" label="BirthDay" prepend-inner-icon="mdi-cake">
                                <VueDatePicker v-model="userData.birthday"></VueDatePicker>
                            </v-text-field>

                            <v-text-field v-model="userData.phoneNumber" label='Number (include "-" when typing)'
                                prepend-inner-icon="mdi-phone"></v-text-field>

                            <v-btn @click="checkRegist" color="warning" block class="mb-3">
                                Validate
                            </v-btn>

                            <v-btn @click="regist" color="success" block class="mb-3">
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
import { ref } from 'vue';
import axios from "../http";
import { VueDaumPostcode } from 'vue-daum-postcode';
import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'
import { watchEffect } from 'vue';

interface User {
    id: string;
    pw: string;
    name: string;
    address: string;
    email: string;
    gender: string;
    phoneNumber: string;
    birthday: Date;
    age: number;
}
const passwordCheck = ref("");
const gender: any = ["male", "female"];
const userData = ref<User>({});
const detailAddress = ref("");
const dialog = ref(false);
const check = ref(false);
const idCheck = ref(false);


const ceheckIdDulicated = async () => {
    let aa = /^[a-z0-9]{7,14}$/;
    if(!aa.test(userData.value.id) || userData.value.id == null){
        alert('Please make it with more than 7 digits and less than 14 digits and a mixture of lowercase letters and numbers.');
        return;
    }
    axios.get(`/api/users/checkId?id=${userData.value.id}`)
        .then((response: any) => {
            if (response.data == 'OK') {
                idCheck.value = true;
                alert('Id avaliable')
            } else {
                alert('Id aleady exist')
                userData.value.id = "";
            }
        })
}

const checkRegist = () => {    
    const pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    const numberPattern = /\d{3}-\d{4}-\d{4}/;    

    if (userData.value.name == null || userData.value.name == "") {
        alert('Insert your NickName')
        return;
    } else if (idCheck.value == false) {
        alert('Id check please')
        return;
    } else if (userData.value.address == null || detailAddress.value == "" || detailAddress.value == null) {
        alert('Insert address or detail address');    
        return;
    } else if (userData.value.birthday == null) {
        alert('Check your birthDaty');
        return;
    } else if (userData.value.gender == null || userData.value.gender == "") {
        alert('Select your gender');
        return;
    } else if (userData.value.pw != passwordCheck.value || userData.value.pw == "") {
        alert('Insert your password or not matches password')
        return;
    } else if (!pattern.test(userData.value.email)) {
        alert('Email is missing or formatted incorrectly.');
        return;
    } else if (!numberPattern.test(userData.value.phoneNumber)) {
        alert('Please do not insert or insert according to the format.')
        return;
    } else {
        check.value = true;
    }
}

const regist = () => {
    if(check.value != true){
        alert("please click the validate button first");
        return;
    } 
    let today = new Date();
    userData.value.age = today.getFullYear() - userData.value.birthday.getFullYear();
    userData.value.address += (" " + detailAddress.value);
    console.log(userData.value);
    if(check.value == true){
        axios.post(`/api/users` , userData.value
        )
        .then((data : any) =>{
            const response  = data;
            console.log(response);
        })
        .finally(() => {
            console.log()
        })
    }
}

const oncomplete = (data: any) => {
    userData.value.address = data.address;
    dialog.value = false;
}

const search = () => {
    dialog.value = true;
}

watchEffect(() => {
    if (userData.value)
        Object.keys(userData.value).forEach((item) => {
            if (item) {
                check.value = false;
            }
        })
})

watchEffect(() => {
    if(userData.value.id)
    idCheck.value = false;    
})
</script>
<style scoped>
.login-main {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
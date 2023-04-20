<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" width="800">                                 
            <v-card>
                <v-card-text>
                   <v-slot name="content"></v-slot>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="green-darken-1" variant="text" @click="dialog = false" >
                    Close
                    </v-btn>                                                
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>
</template>

<script lang="ts" setup>
import { ref } from 'vue';

const dialog = ref(false);

</script>
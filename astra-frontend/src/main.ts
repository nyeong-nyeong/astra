import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import Vue3Storage, { StorageType } from 'vue3-storage'
import { loadFonts } from './plugins/webfontloader'
import { router } from './router'
import axios from 'axios'

loadFonts()

const app = createApp(App);

app.config.globalProperties.$axios = axios;

  app
  .use(vuetify)
  .use(Vue3Storage, { 'namespace': 'pro_', storage:StorageType.Local })
  .use(router)  
  .mount('#app')
 
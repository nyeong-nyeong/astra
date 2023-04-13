import { createWebHistory, createRouter } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/App.vue'), 
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: () => import('@/components/LoginPage.vue'),
  },
];

export const router = createRouter({
  history: createWebHistory(),
  routes,
});
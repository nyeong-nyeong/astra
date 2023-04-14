import { createWebHistory, createRouter } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/components/MainAstra.vue'), 
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: () => import('@/components/LoginPage.vue'),
  },
  {
    path: '/join',
    name: 'JoinPage',
    component: () => import('@/components/JoinPage.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export { router }
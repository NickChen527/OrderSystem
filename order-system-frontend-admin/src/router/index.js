import { createRouter, createWebHistory } from 'vue-router'
import Menu from '@/components/Menu.vue'
import Order from '@/components/Order.vue'

export const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Menu },
    { path: '/order', component: Order }
  ]
});

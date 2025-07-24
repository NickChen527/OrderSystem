import { createRouter, createWebHistory } from 'vue-router'
import Menu from '@/components/Menu/Menu.vue'
import Order from '@/components/Order/Order.vue'
import UpdateMenu from '@/components/Menu/UpdateMenu.vue';
import HomePage from '@/components/HomePage.vue';
import NewMenu from '@/components/Menu/NewMenu.vue';

export const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: HomePage },
    { path: '/menu', name: 'Menu', component: Menu },
    { path: '/order', component: Order },
    //因為要傳入動態參數，所以這邊要加上:menuId，並且要設定name，不然push的時候找不到他
    { path: '/menu/update/:menuId', name: 'UpdateMenu', component: UpdateMenu },
    { path: '/menu/newMenu', name: 'NewMenu', component: NewMenu }
  ]
});

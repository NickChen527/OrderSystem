import { createRouter, createWebHistory } from "vue-router";
import MenuList from "@/components/MenuList.vue";
import Cart from "@/components/Cart.vue";
import Order from "@/components/Order.vue";

export const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', component: MenuList },
        { path: '/cart', name: 'Cart', component: Cart },
        { path: '/order', name: 'Order', component: Order },
    ]
});
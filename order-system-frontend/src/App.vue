<script setup>
import Navbar from './components/Navbar.vue';
import { useOrderStore } from './stores/cartStore';
import { onMounted } from 'vue';

const orderStore = useOrderStore();

onMounted(function(){
    //頁面載入時先把訂單存回Pinia
    const saved = sessionStorage.getItem('orders');    
    if (saved) {
        orderStore.orders = JSON.parse(saved)
    }
});

</script>

<template>
  <Navbar></Navbar>
  <router-view />
</template>

<style scoped>
</style>
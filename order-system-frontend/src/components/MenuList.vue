<script setup>
import { ref, onMounted } from 'vue';
import { getMenu } from '../services/menuService';

const menus = ref([]);

let emit = defineEmits(['addToCart'])

onMounted(async () => {
  menus.value = await getMenu();
});
</script>

<template>
  <div>
    <h2>菜單</h2>
    <ul>
        <li v-for="menu in menus">
            <div>{{ menu.name }}</div>
            <div>{{ menu.price }}</div>
            <div>{{ menu.description }}</div>
            <div>
                <button @click="emit('addToCart',menu)">加入購物車</button>
            </div>
        </li>
    </ul> 
  </div>
</template>
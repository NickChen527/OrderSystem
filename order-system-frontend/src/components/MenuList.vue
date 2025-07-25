<script setup>
import { ref, onMounted } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import { getMenu } from '../services/menuService';

const menus = ref([]);
const cartStore = useCartStore();

onMounted(async () => {
  menus.value = await getMenu();
});

function addToCart(menu) {
  cartStore.addToCart(menu);
}


</script>

<template>
    <div class="container mt-4">
      <h2>菜單</h2>
      <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <!--卡片-->
        <div class="col" v-for="menu in menus">
          <div class="card h-100">
            <img src="https://upload.wikimedia.org/wikipedia/commons/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">{{ menu.name }}   {{ menu.price }}</h5>
              <div class="card-text">{{ menu.description }}</div>
              <div style="margin-top: 10px;">
                <button @click="addToCart(menu)" class="btn btn-primary">加入購物車</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>
<script setup>
import { ref,onMounted } from 'vue';

const orders = ref([]);

onMounted(() => {
  const saved = sessionStorage.getItem('orders');
  if (saved) {
    orders.value = JSON.parse(saved);
  }
});

</script>
<template>
    <div class="d-flex container mt-4 w-50 justify-content-center">
        <div class="row row-cols-1 g-4">
            <!--卡片-->
            <div class="col" v-for="order in orders">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">{{ order.orderId }}</h5>
                        <h6 class="card-subtitle mb-2 text-body-secondary">明細</h6>
                        <ol class="list-group list-group-numbered">
                            <li class="list-group-item" v-for="item in order.items">
                                <span style="margin-right: 15px;">{{ item.menuName }}</span>
                                $<span style="margin-right: 15px;">{{ item.price }}</span>
                                <span>{{ item.quantity }}</span>份
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
</style>
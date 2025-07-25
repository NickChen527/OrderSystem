<script setup>
import { useCartStore } from '@/stores/cartStore';
import { computed } from 'vue';
import { submitOrderApi } from '@/services/orderService';

const cartStore = useCartStore();
const total = computed(()=>{
    let sum = 0;
    for(const item of cartStore.cart){
        sum += item.price*item.quantity
    }
    return sum;
})

async function submitOrder() {
  //包裝成物件，需要餐點ID、數量
  let orderRequest = cartStore.cart.map( (item)=>{return{ "menuId":item.id, "quantity":item.quantity }} );
  //呼叫方法送到後端
  let response =  await submitOrderApi(orderRequest);
  //呼叫成功清空購物車
  if(response){
    console.log('訂單已送出');
    cartStore.cart.value = [];
  }
}
</script>

<template>
    <div class="container mt-4 w-50">
        <h2>訂單明細</h2>
        <ol class="list-group list-group-numbered w-50">
            <li class="list-group-item d-flex justify-content-between align-items-start" v-for="item in cartStore.cart">
                <div class="ms-2 me-auto">
                    <div class="fw-bold">{{ item.name }}</div>
                    $ {{ item.price }}
                </div>
                <span class="badge text-bg-primary rounded-pill">{{ item.quantity }}</span>
            </li>
        </ol>
        <h5 style="margin-top: 10px;">
            總金額：{{ total }}
        </h5>
        <button class="btn btn-primary" style="margin-top: 10px;" @click="submitOrder()">送出訂單</button>        
    </div>
</template>
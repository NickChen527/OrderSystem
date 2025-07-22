<script setup>
import { ref } from 'vue';
import MenuList from './components/MenuList.vue';
import Cart from './components/Cart.vue';
import Order from './components/Order.vue';
import { submitOrderApi } from './services/orderService';

const cart = ref([]);
const orderDetails = ref(null);

function addToCart(menu) {
  //判斷購物車中有沒有相同品項，這邊的find會回傳第一個找到的元素，沒找到會回傳undefined
  const existing = cart.value.find((item)=>{return item.id===menu.id});
  //有，該品項+1
  if(existing){
    existing.quantity+=1;
  //沒有，建立新品項
  }else{
    cart.value.push({...menu, quantity:1});
  }
  console.log(cart.value);
}

async function submitOrder() {
  //包裝成物件，需要餐點ID、數量
  let orderRequest = cart.value.map( (item)=>{return{ "menuId":item.id, "quantity":item.quantity }} );
  //呼叫方法送到後端
  let response =  await submitOrderApi(orderRequest);
  //呼叫成功清空購物車
  if(response){
    console.log('訂單已送出');
    orderDetails.value = response;
    cart.value = [];
  }
}
</script>

<template>
  <h1 class="title">點餐系統</h1>
  <MenuList @addToCart="addToCart"/>
  <Cart v-bind:cart="cart" @submitOrder="submitOrder"/>
  <Order v-if="orderDetails" v-bind:orderDetails="orderDetails"/>
</template>

<style scoped>
.title {
  font-size: 2em;
  text-align: center;
  margin-top: 20px;
}
</style>
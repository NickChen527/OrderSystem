<script setup>
import { ref,onMounted } from 'vue';
import { getOrder,changeOrderStatus } from '@/service/orderService';
const orderList = ref([]);


onMounted(async function(){
    orderList.value = await getOrder();
});

async function confirm(order){
    const data = {
        "orderId":order.id,
        "status":"CONFIRMED"
    };
    const result = await changeOrderStatus(data);
    console.log(result)
    orderList.value = await getOrder();
}

async function cancel(order){
    const data = {
        "orderId":order.id,
        "status":"CANCELLED"
    }
    const result = await changeOrderStatus(data);
    console.log(result);
    orderList.value = await getOrder();
}

</script>

<template>
    <h1>訂單</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">總金額</th>
                <th scope="col">下單時間</th>
                <th scope="col">訂單狀態</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody v-for="order in orderList">
            <tr>
                <th scope="row"><a href="#" >{{ order.id }}</a></th>
                <td>{{ order.totalAmount }}</td>
                <td>{{ order.orderTime }}</td>
                <td v-if="order.orderStatus==='DRAFT'">已接單</td>
                <td v-else-if="order.orderStatus==='CONFIRMED'" style="color: green;">已完成</td>
                <td v-else style="color: red;">已取消</td>
                <td v-if="order.orderStatus==='DRAFT'"><button class="btn btn-primary btn-sm" @click="confirm(order)">已完成</button></td>
                <td v-else></td>
                <td v-if="order.orderStatus==='DRAFT'"><button class="btn btn-danger btn-sm" @click="cancel(order)">已取消</button></td>
                <td v-else></td>
            </tr>
        </tbody>
    </table>
</template>

<style scoped>

</style>
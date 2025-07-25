<script setup>
import { ref,onMounted } from 'vue';
import { getOrder,changeOrderStatus } from '@/service/orderService';
const orderList = ref([]);
//目前頁碼，因為後端的頁面是從0起算，所以這邊也要設為0，下面操作時需要做前置動作
const currentPage = ref(0);
//每頁要有多少資料
const pageSize = 5;
//總共有幾頁
const totalPages = ref(1);

onMounted(
    getOrders
);

//因為下面切換分頁時要用到，所以拆出來寫不直接寫在onMounted裡面
async function getOrders(){
    const pageData = await getOrder(currentPage.value,pageSize);
    orderList.value = pageData.content;
    totalPages.value = pageData.totalPages;
}

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

    <nav>
        <ul class="pagination justify-content-center">
        <li class="page-item" v-bind:class="{ disabled: currentPage === 0 }">
            <button class="page-link" @click="currentPage--, getOrders()" v-bind:disabled="currentPage===0">上一頁</button>
        </li>
        <li class="page-item" v-for="page in totalPages" v-bind:class="{active:page-1===currentPage}">
            <button class="page-link" @click="currentPage = page - 1; getOrders()">{{ page }}</button>
        </li>
        <li class="page-item" :class="{ disabled: currentPage === totalPages - 1 }">
            <button class="page-link" @click="currentPage++, getOrders()" :disabled="currentPage === totalPages - 1">下一頁</button>
        </li>
        </ul>
    </nav>
</template>

<style scoped>

</style>
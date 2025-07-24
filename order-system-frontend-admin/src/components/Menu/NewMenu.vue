<script setup>
import { ref } from 'vue';
import { newMenu } from '@/service/menuService';
import { useRouter } from 'vue-router';
const menu = ref({
    'name':'品項',
    'price':0,
    'description':'Nothing'
})
const route = useRouter();
async function insert(menu){
    const result = await newMenu(menu);
    if(result){
        alert('新增成功');
        route.push({name:'Menu'});
    }
}
</script>
<template>
    <h1>這邊要新增</h1>
    <div class="d-flex justify-content-center align-items-center" style="margin-top: 100px;">
        <form @submit.prevent="insert(menu)">
            <div class="mb-3">
                <label for="menuName" class="form-label">名稱</label>
                <input type="text" class="form-control" id="menuName" v-model="menu.name">
            </div>
            <div class="mb-3">
                <label for="menuPrice" class="form-label">單價</label>
                <input type="text" class="form-control" id="menuPrice" v-model="menu.price">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">商品敘述</label>
                <textarea class="form-control" id="description" rows="3" v-model="menu.description"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</template>
<style scoped>
</style>
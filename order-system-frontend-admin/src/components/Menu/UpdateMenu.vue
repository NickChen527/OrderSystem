<script setup>
import { ref,onMounted } from 'vue';
import { useRoute,useRouter } from 'vue-router';
import { getMenuById,updateMenu } from '@/service/menuService';
const menuId = useRoute().params.menuId;
const router = useRouter();
const menu = ref(null);

onMounted(async function(){
    menu.value = await getMenuById(menuId);
})
async function update(temp){
    const newMenu = await updateMenu(temp);
    console.log('newMenu', newMenu);
    if(newMenu){
        alert("更新成功");
        menu.value = newMenu;
        router.push({name:'Menu'});
    }
}
</script>
<template>
    <div class="d-flex justify-content-center align-items-center" style="margin-top: 100px;">
        <form v-if="menu" @submit.prevent="update(menu)">
            <div class="mb-3">
                <label for="menuId" class="form-label">編號</label>
                <input type="text" class="form-control" id="menuId" v-model="menu.id" readonly>
                <div id="emailHelp" class="form-text">編號不可變動</div>
            </div>
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
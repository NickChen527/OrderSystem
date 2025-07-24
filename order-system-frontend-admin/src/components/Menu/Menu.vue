<script setup>
import { ref,onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { getMenu,deleteMenu } from '@/service/menuService';
const menuList = ref([]);
const router = useRouter();
const menuId = ref(null);

onMounted(async function(){
    menuList.value = await getMenu();
});

function saveMenuId(id){
    menuId.value = id;
}

function updateMenu(menuId){
    //這邊在設定動態參數，語法：push({ name: '要導向的路由名稱', params: { 要加入的動態參數 } })，需要在index.js另外作設定，push就是用來跳轉組件用的
    router.push({name:'UpdateMenu',params:{menuId}})
}

async function deleteM(id){
    const result = await deleteMenu(id);
    if(result.status==='done'){
        //取得 Modal 的 DOM 元素
        const modal = document.getElementById('deleteMenu');
        //取得這個 DOM 對應的 Bootstrap 實例
        const modalInstance = bootstrap.Modal.getInstance(modal);
        //呼叫 .hide() 方法關閉 Modal
        modalInstance.hide();
        alert("刪除成功");
        menuList.value = await getMenu();
    }else{
        const modal = document.getElementById('deleteMenu');
        const modalInstance = bootstrap.Modal.getInstance(modal);
        modalInstance.hide();
        alert("刪除失敗");
        router.push({name:'Menu'});
    }
}

async function newMenu(){
    router.push({name:'NewMenu'});
}
</script>

<template>
    <h1>菜單</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">餐點名稱</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="menu in menuList">
                <th scope="row">{{ menu.id }}</th>
                <td>{{ menu.name }}</td>
                <td><button class="btn btn-primary btn-sm" @click="updateMenu(menu.id)">修改</button></td>
                <td><button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteMenu" @click="saveMenuId(menu.id)">刪除</button></td>
            </tr>
        </tbody>
    </table>
    <button class="btn btn-success" style="margin-top: 40px;" @click="newMenu()">新增品項</button>

    <!-- 刪除菜單時要跳出的Modal -->
    <div class="modal fade" id="deleteMenu" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">刪除確認</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                此操作不可逆，且會刪除所有相關的訂單明細，確定要刪除嗎?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" @click="deleteM(menuId)">確認</button>
            </div>
            </div>
        </div>
    </div>
</template>

<style scoped>

</style>
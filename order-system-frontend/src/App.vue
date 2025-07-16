<script setup>
    import { onMounted,ref } from 'vue';
    import { getMenu } from './services/menuService';
    let menuList = ref([]);

    onMounted(function(){
      getMenu().then(function(data){
        menuList.value = data;
      })
    });

</script>

<template>
    <nav class="navbar bg-body-tertiary">
      <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">菜單</span>
      </div>
    </nav>
    <main>
      <div class="container">
        <div class="row">
          <div class="col">
            <div v-if="menuList.length===0">菜單載入中</div>
            <ul v-else class="list-group mt-5">
              <li v-for="item in menuList" class="list-group-item">
                <div>{{ item.name }}</div>
                <div>{{ item.price }}</div>
                <div>{{ item.description }}</div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </main>
</template>

<style scoped>
</style>
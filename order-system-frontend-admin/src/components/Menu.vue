<script setup>
import { ref,onMounted } from 'vue';
const menuList = ref([]);
onMounted(function(){
    
});
</script>

<template>
    <h1>菜單</h1>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
    </ul>
</template>

<style scoped>

</style>
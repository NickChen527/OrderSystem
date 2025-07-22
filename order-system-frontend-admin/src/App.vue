<script setup>
import SideBar from './components/SideBar.vue';
</script>
<template>
  <div class="container-fluid">
    <div class="row">
      <!-- Sidebar 區塊 -->
      <div class="col-lg-2 col-md-3 col-sm-4 p-0">
        <SideBar />
      </div>
      <div class="col-lg-10 col-md-9 col-sm-8 p-4 mt-3">
        <router-view />
      </div>
    </div>
  </div>
</template>
<style scoped>
</style>
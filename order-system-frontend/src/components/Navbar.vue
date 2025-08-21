<script setup>
</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <!-- 品牌/Logo（可放 router-link） -->
      <router-link to="/" class="navbar-brand">OrderSystem</router-link>

      <!-- 漢堡按鈕：小螢幕時出現，點擊後開/關折疊區塊 -->
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- 折疊區塊：id 要跟 data-bs-target 對應 -->
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <router-link to="/" class="nav-link" exact-active-class="active">首頁</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/order" class="nav-link" active-class="active">我的訂單</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/cart" class="nav-link" active-class="active">查看購物車</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped>
</style>
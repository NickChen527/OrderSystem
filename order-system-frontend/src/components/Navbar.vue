<script setup>
</script>

<template>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <router-link to="/" class="nav-link active">首頁</router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/order" class="nav-link">我的訂單</router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/cart" class="nav-link">查看購物車</router-link>
                </li>
            </ul>
        </div>
    </div>
</nav>
</template>

<style scoped>
</style>
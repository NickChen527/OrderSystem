<script setup>
</script>
<template>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark align-items-center"
        style="width: auto; height: 100vh;">
        <span class="fs-4">後臺介面</span>
        <hr>
        <ul class="nav nav-pills mb-auto flex-column" role="tablist">
            <li class="nav-item" role="presentation">
                <router-link to="/" class="nav-link" active-class="active">菜單</router-link>
            </li>
            <li class="nav-item" role="presentation">
                <router-link to="/order" class="nav-link" active-class="active">訂單</router-link>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                data-bs-toggle="dropdown">
                <strong>用戶操作</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                <li><a class="dropdown-item" href="#">登入</a></li>
                <li><a class="dropdown-item" href="#">登出</a></li>
            </ul>
        </div>
    </div>
</template>
<style scoped>
</style>
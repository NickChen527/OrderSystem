<script setup>
    const props = defineProps(['orderDetails']);
</script>
<template>
    <div v-for="item in props.orderDetails.items">
        <div>
            <span>{{ item.quantity }}  </span> <span>{{ item.menuName }}  </span> <span>{{ item.price }}</span>
        </div>
    </div>
    <div>
        總金額：{{ props.orderDetails.total }}
    </div>
</template>

<style scoped>

</style>
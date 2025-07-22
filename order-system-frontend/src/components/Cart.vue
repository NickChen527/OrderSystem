<script setup>
    const props = defineProps(['cart'])
    let emit = defineEmits(['submitOrder'])
</script>

<template>
    品項
    <div v-for="item in props.cart">
        {{ item.name }}<br>
        {{ item.price }}<br>
        {{ item.quantity }}<br>
    </div>
    <button @click="emit('submitOrder')">送出訂單</button>
</template>
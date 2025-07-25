import { defineStore } from "pinia";
import { ref } from "vue";

export const useCartStore = defineStore(
    'cart', function () {
        const cart = ref([]);

        function addToCart(menu) {
            //判斷購物車中有沒有相同品項，這邊的find會回傳第一個找到的元素，沒找到會回傳undefined
            const existing = cart.value.find((item) => { return item.id === menu.id });
            //有，該品項+1
            if (existing) {
                existing.quantity += 1;
                //沒有，建立新品項
            } else {
                cart.value.push({ ...menu, quantity: 1 });
            }
        }

        return {
            cart, addToCart
        }
    }
)

export const useOrderStore = defineStore(
    'order', function () {
        const orders = ref([]);
        return { orders }
    }
);
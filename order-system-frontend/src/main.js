//載入 createApp 函式
import { createApp } from "vue";
//加入Pinia
import { createPinia } from "pinia";
//載入根組件
import App from "./App.vue";
//加入router
import { router } from './router';
// CSS
import 'bootstrap/dist/css/bootstrap.min.css';
// JS（一定要這行，否則漢堡按鈕不會有作用）
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
//建立Pinia
const pinia = createPinia();
//建立 Vue App 物件
const app = createApp(App).use(router).use(pinia);
//掛載到 HTML 標籤底下
app.mount("#app");


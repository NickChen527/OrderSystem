//載入 createApp 函式
import { createApp } from "vue";
//載入根組件
import App from "./App.vue";
//建立 Vue App 物件
const app = createApp(App);
//掛載到 HTML 標籤底下
app.mount("#app");
const BASE_URL = 'https://ordersystem-8dln.onrender.com/api';

//取得分頁訂單
export async function getOrder(page = 0, size = 5) {
    const result = await fetch(`${BASE_URL}/orders?page=${page}&size=${size}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" }
    });
    return await result.json();
}

//更新訂單狀態
export async function changeOrderStatus(data) {
    const result = await fetch(`${BASE_URL}/orders`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    });
    return await result.json();
}
const BASE_URL = 'http://localhost:8080/api';

//取得所有訂單
export async function getOrder() {
    const result = await fetch(`${BASE_URL}/orders`, {
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
const BASE_URL = 'http://localhost:8080/api';

export async function submitOrderApi(orderItems) {
    const res = await fetch(`${BASE_URL}/orders`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ items: orderItems })
    });
    return await res.json();
}
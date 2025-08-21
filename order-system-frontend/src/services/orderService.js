const BASE_URL = import.meta.env.VITE_API_URL;

export async function submitOrderApi(orderItems) {
    const res = await fetch(`${BASE_URL}/orders`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ items: orderItems })
    });
    return await res.json();
}
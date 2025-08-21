const BASE_URL = import.meta.env.VITE_API_URL;

export async function getMenu() {
    const result = await fetch(`${BASE_URL}/menus`);
    return await result.json();
}
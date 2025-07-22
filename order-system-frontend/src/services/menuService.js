const BASE_URL = 'http://localhost:8080/api';

export async function getMenu() {
    const result = await fetch(`${BASE_URL}/menus`);
    return await result.json();
}
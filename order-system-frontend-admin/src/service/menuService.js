const BASE_URL = 'http://localhost:8080/api';

//取全部菜單
export async function getMenu() {
    const result = await fetch(`${BASE_URL}/menus`, {
        method: "GET",
        headers: { "Content-Type": "application/json" }
    });
    return await result.json();
}

//找單筆菜單
export async function getMenuById(menuId) {
    const result = await fetch(`${BASE_URL}/menus/${menuId}`, {
        method: "GET",
        headers: { "Content_Type": "application/json" }
    });
    return await result.json();
}

//更新菜單
export async function updateMenu(temp) {
    let menuId = temp.id;
    const result = await fetch(`${BASE_URL}/menus/${menuId}`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(temp)
    });
    return await result.json();
}

//刪除菜單
export async function deleteMenu(menuId) {
    const result = await fetch(`${BASE_URL}/menus/${menuId}`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" }
    });
    return await result.json();
}

//新增菜單
export async function newMenu(temp) {
    const result = await fetch(`${BASE_URL}/menus`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(temp)
    });
    return await result.json();
}
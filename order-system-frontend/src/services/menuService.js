export function getMenu() {
    return fetch("http://localhost:8080/api/menus", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        return response.json();
    });
}
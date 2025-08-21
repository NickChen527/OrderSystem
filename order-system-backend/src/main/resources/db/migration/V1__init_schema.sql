CREATE TABLE menu (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    order_time TIMESTAMP NOT NULL,
    total_amount DOUBLE PRECISION NOT NULL,
    status VARCHAR(20)
);

CREATE TABLE order_item (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    menu_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    item_price DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_order_item_menu
        FOREIGN KEY (menu_id) REFERENCES menu (id)
);
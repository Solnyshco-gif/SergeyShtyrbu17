-- Вставка категорий (первыми, так как они нужны для товаров)
INSERT INTO categories (id, name) VALUES
(1, 'Суши'),
(2, 'Напитки');

-- Вставка клиентов
INSERT INTO clients (id, external_id, full_name, phone_number, address) VALUES
(1, 1001, 'Иван Петров', '+79161234567', 'ул. Ленина, 1'),
(2, 1002, 'Анна Сидорова', '+79031234568', 'пр. Мира, 10');

-- Вставка товаров (с указанием category_id)
INSERT INTO products (id, name, description, price, category_id) VALUES
(1, 'Ролл Филадельфия', 'Классический ролл с лососем', 250.0, 1),
(2, 'Кола', 'Газированный напиток', 100.0, 2);

-- Вставка заказов
INSERT INTO client_orders (id, status, total, client_id) VALUES
(1, 1, 350.0, 1),
(2, 2, 500.0, 2);

-- Вставка связи товаров с заказами
INSERT INTO order_products (id, count_product, client_order_id, product_id) VALUES
(1, 1, 1, 1),
(2, 2, 1, 2),
(3, 3, 2, 1);
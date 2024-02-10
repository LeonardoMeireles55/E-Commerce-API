
-- Create Product table with foreign key reference to Category
CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DOUBLE(10, 2) NOT NULL,
    quantity_in_stock INT NOT NULL,
    category VARCHAR(255),
    photo_link TEXT,
    off_price DOUBLE(10,2) NOT NULL,
    stars INT
);

-- Create Order table with foreign key reference to Customer
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    status VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create OrderItem table with foreign key references to Product and Order
CREATE TABLE order_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT NOT NULL,
    unit_price DOUBLE(10, 2),
    product_id INT,
    order_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

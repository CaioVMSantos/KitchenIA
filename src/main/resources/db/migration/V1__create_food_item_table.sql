CREATE TABLE food_item (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL,
        category VARCHAR(100),
        quantity INT,
        validate DATE
);

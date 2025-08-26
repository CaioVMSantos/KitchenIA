CREATE TABLE food_item (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    quantity INT,
    validate DATE
);


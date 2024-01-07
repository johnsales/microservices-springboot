CREATE TABLE IF NOT EXISTS product_availability (
    uniq_id VARCHAR(255) NOT NULL,
    in_stock BOOLEAN NOT NULL,
    PRIMARY KEY (uniq_id)
    );

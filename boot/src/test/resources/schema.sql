DROP TABLE IF EXISTS PRICE;
CREATE TABLE PRICE (
                       ID INT PRIMARY KEY,
                       BRAND_ID INT NOT NULL,
                       START_DATE VARCHAR(50) NOT NULL,
                       END_DATE VARCHAR(50) NOT NULL,
                       PRICE_LIST INT NOT NULL,
                       PRODUCT_ID INT NOT NULL,
                       PRIORITY INT NOT NULL,
                       PRICE DOUBLE PRECISION NOT NULL,
                       CURR VARCHAR(50) NOT NULL
);

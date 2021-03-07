DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;

CREATE TABLE menus (
                       menu_id INT AUTO_INCREMENT  PRIMARY KEY,
                       category VARCHAR(250) NOT NULL,
                       itemNo INT NOT NULL,
                       itemName VARCHAR(250) DEFAULT NULL,
                       quantityAvailable INT DEFAULT NULL,
                       price INT DEFAULT NULL
);
CREATE TABLE orders (
                        order_id INT AUTO_INCREMENT  PRIMARY KEY,
                        user_id VARCHAR(250) NOT NULL,
                        menu_id VARCHAR(250) DEFAULT NULL
);

CREATE TABLE users (
                       user_id INT AUTO_INCREMENT  PRIMARY KEY,
                       fullname VARCHAR(250) NOT NULL,
                       user_name VARCHAR(250) DEFAULT NULL,
                       password VARCHAR(250) DEFAULT NULL,
                       signedin VARCHAR (250) DEFAULT NULL
);
DROP TABLE IF EXISTS menus;

CREATE TABLE menus (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       category VARCHAR(250) NOT NULL,
                       itemNo INT NOT NULL,
                       itemName VARCHAR(250) DEFAULT NULL,
                       quantityAvailable INT DEFAULT NULL,
                       price INT DEFAULT NULL
);

insert into menus values(101,'Soup', 'Chicken Soup',1,50,5);
insert into menus values(102,'Starter', 'Chicken Lolipop',2,3,7);
insert into menus values(103,'MainCourse', 'Chicken Biryani',3,50,13);

insert into users values(111,'Arumugam', 'Arul',true,'Arul5681');
insert into users values(112,'Anbuselvi', 'Arul',true,'Anbu2505');
insert into users values(113,'Lakshana', 'Arul',true,'Laks0610');
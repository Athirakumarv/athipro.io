SELECT * FROM truyum.menu_item;
use truyum;

INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Sandwich', '99.00', 'Yes', '2017-03-15', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Burger', '129.00', 'Yes', '2020-12-23', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Pizza', '149.00', 'Yes', '2018-08-21', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('French Fries', '57.00', 'No', '2020-07-02', 'Starters ', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Chocolate Brownie', '32.00', 'Yes', '2022-11-02', 'Dessert', 'Yes');

insert into user(us_id,us_name) values(1,'Athira');
insert into user(us_id,us_name) values(1,'achu');

SELECT * FROM truyum.menu_item
where menu_item.me_date_of_launch>=CURDATE() and me_active='Yes';

SELECT * FROM truyum.menu_item
where me_id='5';

update truyum.menu_item
set
me_name='Biriyani',
me_price='100.00',
me_date_of_launch='2018-03-03',
me_free_delivery='No'
where me_id='1';

insert into truyum.cart(ct_us_id,ct_me_id) values(1,1);
insert into truyum.cart(ct_us_id,ct_me_id) values(1,2);
insert into truyum.cart(ct_us_id,ct_me_id) values(1,3);
insert into truyum.cart(ct_us_id,ct_me_id) values(2,3);

select menu_item.me_name,menu_item.me_free_delivery,menu_item.me_price from cart
inner join menu_item on menu_item.me_id=cart.ct_me_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id='1';


select truyum.user.us_id,sum(menu_item.me_price) as Total from cart 
inner join menu_item on menu_item.me_id=cart.ct_me_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id='1';

delete from truyum.cart where ct_us_id=2 and ct_me_id=3;


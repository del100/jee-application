-- You can use this file to load seed data into the database using SQL statements

-- OfferCategory 
insert into OfferCategory ( description) values ( 'Clothing');
insert into OfferCategory ( description) values ( 'Toys');

-- Retailer
insert into Retailer ( name, vatNumber) values ( 'TheCrazyClothesShop', 'ss45321qw');
insert into Retailer ( name, vatNumber) values ( 'TomsToys', 'ss56789rt');

-- User 
insert into User ( userName, password, retailer_id) values ( 'user1', 'pass1', 1);
insert into User ( userName, password, retailer_id) values ( 'user2', 'pass2', 2);

-- Offer
insert into Offer ( url, description, category_id, retailer_id) values ( 'http://www.sometest/shirt', 'A really nice shirt', 1, 1);
insert into Offer ( url, description, category_id, retailer_id) values ( 'http://www.tomsToys/car', 'A toy car', 2, 2);


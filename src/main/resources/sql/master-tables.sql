create table users (
	id int PRIMARY KEY AUTO_INCREMENT, 
	name varchar(50), 
	email varchar(100),
	phone varchar(20)
);

create table claims (
	id int PRIMARY KEY AUTO_INCREMENT, 
	description varchar(50),
	user_id int,
	amount float,
	claim_date timestamp
);



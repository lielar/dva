create table users (
	id int PRIMARY KEY AUTO_INCREMENT, 
	name varchar(50), 
	email varchar(100),
	phone varchar(20)
);

create table books (
	id int PRIMARY KEY AUTO_INCREMENT, 
	title varchar(50),
	author varchar(50),
	isbn varchar(50)
);

create table borrowers (
	id int PRIMARY KEY AUTO_INCREMENT, 
	book_id int, 
	user_id int, 
	borrowed_date date, 
	due_date date,

	foreign key(book_id) references books(id),
	foreign key(user_id) references users(id)
);



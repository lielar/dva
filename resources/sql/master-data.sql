insert into users (name, phone, email) values ('Albert Sinclair', '555-9989', 'albert@test.com');

insert into users (name, phone, email) values ('Bob Kincaid', '555-1122', 'bob@test.com');

insert into users (name, phone, email) values ('Samuel Smith', '555-1122', 'sam@test.com');

insert into users (name, phone, email) values ('Lucy Justice', '555-0012', 'lucy@test.com');

insert into books (title, author, isbn) values ('It', 'Stephen King', 'B003BKZW7C');

insert into books (title, author, isbn) values ('Audacity of Hope', 'Barak Obama', 'B00573YW5Y');

insert into books (title, author, isbn) values ('The Chronicles of Narnia', 'CS Lewis', 'B00CR42MOY');

insert into books (title, author, isbn) values ('Superman Chronicles', 'Jerome Siegel', '1401207642');

insert into books (title, author, isbn) values ('How to Win Friends and Influence People', 'Dale Carnegie', '0762462019');

insert into borrowers (book_id, user_id, borrowed_date, due_date) values (1, 1, '2016-10-14', '2016-11-14');

insert into borrowers (book_id, user_id, borrowed_date, due_date) values (2, 2, '2016-10-13', '2016-11-13');

insert into borrowers (book_id, user_id, borrowed_date, due_date) values (3, 3, '2016-10-15', '2016-11-15');

insert into borrowers (book_id, user_id, borrowed_date, due_date) values (4, 3, '2016-10-15', '2016-11-15');

insert into borrowers (book_id, user_id, borrowed_date, due_date) values (5, 3, '2016-10-15', '2016-11-15');

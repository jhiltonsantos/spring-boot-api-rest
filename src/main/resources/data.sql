INSERT INTO USER(name, email, password) VALUES ('Hilton', 'hilton@email.com', '$2a$10$n4X21FiWsMOhgQVibsXnXejmTqEMQYRS.578xWXNIcHZa7.M6XD0O');
INSERT INTO USER(name, email, password) VALUES ('Moderador', 'moderador@email.com', '$2a$10$n4X21FiWsMOhgQVibsXnXejmTqEMQYRS.578xWXNIcHZa7.M6XD0O');

INSERT INTO PROFILE(id, name) VALUES (1, 'ROLE_STUDENT');
INSERT INTO PROFILE(id, name) VALUES (2, 'ROLE_MODERATOR');

INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES (1,1);
INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES (2,2);


-- INSERT INTO COURSE(name, category) VALUES ('ADS', 'Tecnologia da Informaçao');
-- INSERT INTO COURSE(name, category) VALUES ('Biologia', 'Ciencias Biologicas');
-- INSERT INTO COURSE(name, category) VALUES ('Engenharia Mecanica', 'Engenharias');

-- INSERT INTO TOPIC(title, message, date_create, status, author_id, course_id) VALUES ('Duvida', 'Duvida ao gerar spring boot', '2021-12-16 20:00:00', 'NAO_RESPONDIDO', 1, 1);
-- INSERT INTO TOPIC(title, message, date_create, status, author_id, course_id) VALUES ('Duvida Flutter', 'Utilizando flexible', '2021-12-16 15:00:00', 'SOLUCIONADO', 2, 1);
-- INSERT INTO TOPIC(title, message, date_create, status, author_id, course_id) VALUES ('Duvida Biologia', 'Formacao do RNA', '2021-12-16 15:00:00', 'SOLUCIONADO', 2, 2);

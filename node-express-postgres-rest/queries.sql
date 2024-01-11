CREATE TABLE person(
id SERIAL PRIMARY KEY,
firstname VARCHAR(30),
lastname VARCHAR(30)
);

CREATE TABLE post(
id SERIAL PRIMARY KEY,
title VARCHAR(255),
content VARCHAR(255),
user_id INTEGER,
FOREIGN KEY (user_id) REFERENCES person (id)
);

INSERT INTO persons(firstname, lastname)
VALUES
('Mick', 'Wazowsky'),
('Harry', 'Shrotter'),
('Ivan', 'Bunov'),
('John', 'Doe');

INSERT INTO posts (title, content, user_id)
VALUES
('Sunday', 'Hello everyone! Today is sunday, weather is sunny!', 1),
('JOB', 'Looking for someone who can help me do a job', 2),
('Birthday', 'This is a TICKET for the PARTY', 1),
('New video', 'I finished to make a new video', 3),
('Chat', 'Welcome to our neighborhood chat', 4),
('Car', 'my car is down today', 2),
('Move out', 'Hello there. Im move out to NY', 3),
('Voyage', 'My vacation start on Monday', 4);
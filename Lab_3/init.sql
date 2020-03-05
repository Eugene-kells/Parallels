CREATE SCHEMA lab;
CREATE USER uni_lad WITH ENCRYPTED PASSWORD 'admin123';


CREATE TABLE lab.groups (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE lab.students (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    group_id INTEGER REFERENCES lab.groups(id) ON DELETE CASCADE
);

CREATE TABLE lab.scores (
    id SERIAL PRIMARY KEY,
    score INTEGER CHECK (0 <= score AND score <= 100) NOT NULL,
    datestamp DATE DEFAULT CURRENT_DATE,
    student_id INTEGER REFERENCES lab.students(id) ON DELETE CASCADE
);


GRANT ALL PRIVILEGES ON lab.students TO uni_lad;
GRANT ALL PRIVILEGES ON lab.groups TO uni_lad;
GRANT ALL PRIVILEGES ON lab.scores TO uni_lad;


INSERT INTO lab.groups (name)
VALUES ('LOL-61'),
       ('LOL-62'),
       ('LOL-63');


INSERT INTO lab.students (name, surname, group_id)
VALUES ('Phelan', 'Kelly', 1),
       ('Ralph', 'Garcia', 2),
       ('Cade', 'Schneider', 1),
       ('Driscoll', 'Bernard', 1),
       ('Jack', 'Wilder', 1),
       ('Denton', 'Duran', 3),
       ('Garrison', 'Carter', 2),
       ('Keefe', 'Mcpherson', 2),
       ('Silas', 'Beard', 2),
       ('Nolan', 'Bauer', 1),
       ('Donovan', 'Stanton', 2),
       ('Murphy', 'Dominguez', 1),
       ('Kirk', 'Higgins', 2),
       ('Solomon', 'Velasquez', 2),
       ('Macaulay', 'Hurley', 3),
       ('Raja', 'Carpenter', 1),
       ('Hilel', 'Calhoun', 2),
       ('Camden', 'Moreno', 2),
       ('Matthew', 'Cross', 2),
       ('Maxwell', 'Burt', 3),
       ('Yoshio', 'Jacobson', 3),
       ('Grady', 'Bradford', 1),
       ('Matthew', 'Benson', 2),
       ('Amery', 'Herman', 3),
       ('Vaughan', 'Walsh', 3),
       ('Rajah', 'Jarvis', 2),
       ('Lev', 'Olson', 1),
       ('Chancellor', 'Mcfarland', 2),
       ('Clarke', 'Davenport', 1),
       ('Geoffrey', 'Nelson', 3),
       ('Dante', 'Lyons', 3),
       ('Xavier', 'Lynch', 3),
       ('Zachary', 'Rogers', 1),
       ('Brendan', 'Parker', 2),
       ('Ciaran', 'Thomas', 3),
       ('Hayden', 'Avery', 2),
       ('Arthur', 'Weeks', 3),
       ('Quamar', 'Thornton', 1),
       ('Gage', 'Wilkerson', 3),
       ('Marvin', 'Barr', 1),
       ('Steven', 'Irwin', 2),
       ('Herrod', 'Boyd', 2),
       ('Boris', 'Roberts', 2),
       ('Leonard', 'Ross', 3),
       ('Wayne', 'Wilkins', 1),
       ('Lane', 'Franco', 1),
       ('Darius', 'Good', 2),
       ('Ian', 'Harrell', 3),
       ('Andrew', 'Herring', 3),
       ('Bruce', 'Charles', 1),
       ('Keane', 'Mcmillan', 2),
       ('Victor', 'Alexander', 1),
       ('Brock', 'Blackwell', 1),
       ('Kaseem', 'Whitney', 3),
       ('Asher', 'Rice', 1),
       ('Allistair', 'Carpenter', 2),
       ('Cooper', 'Strickland', 2),
       ('Quentin', 'Navarro', 1),
       ('Avram', 'Mueller', 1),
       ('Wesley', 'Peck', 1),
       ('Ivor', 'Potter', 2),
       ('Lars', 'Savage', 1),
       ('Grant', 'Mcfarland', 2),
       ('Lev', 'Keller', 2),
       ('Dane', 'Palmer', 3),
       ('Malcolm', 'Mayo', 3),
       ('Hamilton', 'Gomez', 3),
       ('Burke', 'Sims', 3),
       ('Edan', 'Mcleod', 2),
       ('Yardley', 'Mills', 3),
       ('Brody', 'Cantrell', 3),
       ('Jamal', 'Wilcox', 1),
       ('William', 'Lane', 1),
       ('Keaton', 'Cain', 1),
       ('Oliver', 'Mcintosh', 2),
       ('Dexter', 'Austin', 1),
       ('Gabriel', 'Madden', 2),
       ('Nicholas', 'Patterson', 3),
       ('Stewart', 'Lott', 2),
       ('Clarke', 'Potter', 3),
       ('Walter', 'Strong', 2),
       ('Jacob', 'Berry', 2),
       ('Walker', 'Noel', 2),
       ('Jordan', 'Hyde', 1),
       ('Baxter', 'Steele', 3),
       ('Rashad', 'Fisher', 3),
       ('Mason', 'Jordan', 3),
       ('Wesley', 'Reese', 3),
       ('Merritt', 'Craig', 3),
       ('Jonas', 'Huber', 2),
       ('Theodore', 'Farmer', 3),
       ('Keefe', 'Oconnor', 3),
       ('Kieran', 'Oneal', 3),
       ('Knox', 'Crane', 1),
       ('Louis', 'Kent', 3),
       ('Lamar', 'Marquez', 3),
       ('Emerson', 'Rowe', 1),
       ('Cade', 'Fleming', 2),
       ('Dorian', 'Bird', 1),
       ('Melvin', 'Deleon', 2);
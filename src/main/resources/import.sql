INSERT INTO category (title)
VALUES 
('Information Technology and Software Development'),
('Finance and Accounting'),
('Marketing and Advertising'),
('Human Resources and Talent Acquisition'),
('Healthcare and Medical Services'),
('Engineering and Architecture'),
('Education and Training'),
('Sales and Customer Relations'),
('Creative Arts and Design'),
('Consulting and Strategy');

INSERT INTO application_user (username, password)
VALUES
('skywalker', 'Force123'),
('treasureHunter', 'XmarkstheSpot!'),
('cyberNinja', 'S3cur3P@ss'),
('musicMaestro', 'Melody123$'),
('wanderlust23', 'GlobeTrotter!'),
('codeWizard', 'MagicCode$'),
('coffeeAddict', 'Caf3in@te'),
('bookworm', 'Read1234'),
('gardenGuru', 'Fl0w3rP0w3r!'),
('midnightRider', 'N1ghtOwl&');

INSERT INTO entry (checkIn, checkOut, category_id, applicationuser_id)
VALUES
('2022-03-10T12:15:50', '2022-03-10T12:50:50', 1, 1 ), 
('2022-03-10T13:00:00', '2022-03-10T13:30:00', 2, 2 ),
('2022-03-10T14:00:00', '2022-03-10T14:45:00', 3, 1 ),
('2022-03-10T15:10:00', '2022-03-10T15:45:00', 4, 3 ),
('2022-03-10T16:20:00', '2022-03-10T16:50:00', 5, 4 ),
('2022-03-10T17:30:00', '2022-03-10T18:00:00', 6, 5 ),
('2022-03-11T08:00:00', '2022-03-11T08:30:00', 7, 6 ),
('2022-03-11T09:45:00', '2022-03-11T10:15:00', 8, 7 ),
('2022-03-11T11:20:00', '2022-03-11T12:00:00', 9, 8 ),
('2022-03-11T13:30:00', '2022-03-11T14:00:00', 10, 9 );


INSERT INTO tag (title)
VALUES
('Technology'),
('Marketing'),
('Healthcare'),
('Finance'),
('Education'),
('Artificial Intelligence'),
('Customer Service'),
('Engineering'),
('Design'),
('Sales');

INSERT Into entry_tags (entry_id, tag_id)
VALUES
(1,2),
(2,3),
(3,4),
(4,5),
(5,6),
(7,8),
(9,10),
(10,1),
(9,2),
(8,3);


--liquibase formatted sql

--changeset serge:1
INSERT INTO remind (title, description, remind) VALUES
                                                      ('Meeting with team', 'Discuss project updates', '2024-03-10 10:00:00'),
                                                      ('Dentist appointment', 'Visit dentist for checkup', '2024-03-11 15:00:00'),
                                                      ('Gym workout', 'Leg day training session', '2024-03-12 18:30:00'),
                                                      ('Grocery shopping', 'Buy vegetables and fruits', '2024-03-13 09:00:00'),
                                                      ('Read a book', 'Finish reading "Atomic Habits"', '2024-03-14 20:00:00'),
                                                      ('Doctor appointment', 'Routine health checkup', '2024-03-15 11:00:00'),
                                                      ('Team meeting', 'Sprint planning discussion', '2024-03-16 14:00:00'),
                                                      ('Family dinner', 'Dinner at Italian restaurant', '2024-03-17 19:30:00'),
                                                      ('Coding practice', 'Solve LeetCode problems', '2024-03-18 21:00:00'),
                                                      ('Call mom', 'Catch up with mom on the phone', '2024-03-19 17:00:00'),
                                                      ('Presentation prep', 'Prepare slides for meeting', '2024-03-20 13:00:00'),
                                                      ('Visit bank', 'Discuss mortgage options', '2024-03-21 10:30:00'),
                                                      ('Weekend hiking', 'Hiking trip to the mountains', '2024-03-22 07:00:00'),
                                                      ('Car maintenance', 'Oil change and tire check', '2024-03-23 09:30:00'),
                                                      ('Online course', 'Complete Java Spring Boot module', '2024-03-24 16:00:00'),
                                                      ('Yoga session', 'Morning yoga routine', '2024-03-25 06:30:00'),
                                                      ('Write blog post', 'Publish tech article on Medium', '2024-03-26 20:00:00'),
                                                      ('Buy birthday gift', 'Get a present for Alex', '2024-03-27 18:00:00'),
                                                      ('Water the plants', 'Take care of indoor plants', '2024-03-28 08:00:00'),
                                                      ('Plan vacation', 'Research destinations for summer', '2024-03-29 15:00:00');
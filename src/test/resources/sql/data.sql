INSERT INTO remind (id ,title, description, remind)
VALUES
    (1,'Meeting with client', 'Discussion about new project', '2025-03-15T10:00:00'),
    (2,'Doctor appointment', 'Annual health checkup', '2025-03-16T09:30:00'),
    (3,'Team lunch', 'Lunch with the development team', '2025-03-17T13:00:00'),
    (4,'Project deadline', 'Finish the final report for project X', '2025-03-20T17:00:00'),
    (5,'Family gathering', 'Weekend family get-together', '2025-03-25T18:00:00');
SELECT SETVAL('remind_id_seq', (SELECT MAX(id) FROM remind));
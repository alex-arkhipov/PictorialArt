INSERT INTO Authors (FullName, FName, MName, LName, BYear, DYear, Sex) VALUES ('Александр Сергеевич Пушкин', 'Александр', 'Сергеевич', 'Пушкин', 1799, 1836, 1);
INSERT INTO Authors (FullName, FName, MName, LName, BYear, DYear, Sex) VALUES ('Федор Михайлович Грибоедов', 'Федор', 'Михайлович', 'Достоевский', null, null, 1);
INSERT INTO Authors (FullName, FName, MName, LName, BYear, DYear, Sex) VALUES ('Лев Николаевич Толстой', 'Лев', 'Николаевич', 'Толстой', null, null, 1);

INSERT INTO genres(id, Genre) VALUES (1, 'Импрессионизм');
INSERT INTO genres(id, Genre) VALUES (2, 'Куббизм');

INSERT INTO Descriptions(id, Description) VALUES (1, 'Это пример описания картины.');
INSERT INTO Descriptions(id, Description) VALUES (2, 'Это пример описания картины 222.');

INSERT INTO Productions(AuthorID, Title, DescriptionID, CYear, GenreID, Filename, Popularity) VALUES (SELECT (id) from Authors WHERE LNAME='Пушкин', 'Памятник', 1, 1836, 2, 'xxx.jpg', 1);
INSERT INTO Productions(AuthorID, Title, DescriptionID, CYear, GenreID, Filename, Popularity) VALUES (SELECT (id) from Authors WHERE LNAME='Достоевский', 'Последний день Помпеи', 2, 1836, 2, 'xxx2.jpg', 5);

INSERT INTO Players(Nickname,Name,Sex,Hash,Age, LastAccess, Scores, Email) VALUES ('Neo', 'Alex Arkhipov', 1,'fdfdsfdfs', 36, CURDATE(), 0, 'arkhipov@mera.ru');

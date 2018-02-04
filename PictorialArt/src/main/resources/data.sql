INSERT INTO Authors (FullName, FName, MName, LName, BYear, DYear, Sex) VALUES ('Александр Сергеевич Пушкин', 'Александр', 'Сергеевич', 'Пушкин', 1799, 1836, 1);
INSERT INTO Authors (FullName, FName, MName, LName, BYear, DYear, Sex) VALUES ('Федор Михайлович Грибоедов', 'Федор', 'Михайлович', 'Достоевский', null, null, 1);
INSERT INTO Authors (FullName, FName, MName, LName, BYear, DYear, Sex) VALUES ('Лев Николаевич Толстой', 'Лев', 'Николаевич', 'Толстой', null, null, 1);

INSERT INTO  stattypes(id, StatType) VALUES (1, 'Unset');
INSERT INTO  stattypes(id, StatType) VALUES (2, 'WorkStat');
INSERT INTO  stattypes(id, StatType) VALUES (3, 'WorkTitleStat');
INSERT INTO  stattypes(id, StatType) VALUES (4, 'WorkAuthorStat');

INSERT INTO Types(id, Type) VALUES (1, 'Поэзия');
INSERT INTO Types(id, Type) VALUES (2, 'Проза');
INSERT INTO Types(id, Type) VALUES (3, 'Белый стих');

INSERT INTO genres(id, Genre) VALUES (1, 'Любовная лирика');
INSERT INTO genres(id, Genre) VALUES (2, 'Философская лирика');

INSERT INTO texts(id, Text) VALUES (1,
'Я памятник себе воздвиг нерукотворный,
К нему не заростет народная тропа,
Вознесся выше он главою непокорной
Александрийского столпа.

Нет, весь я не умру — душа в заветной лире
Мой прах переживет и тленья убежит —
И славен буду я, доколь в подлунном мире
Жив будет хоть один пиит.

Слух обо мне пройдет по всей Руси великой,
И назовет меня всяк сущий в ней язык,
И гордый внук славян, и финн, и ныне дикой
Тунгуз, и друг степей калмык.

И долго буду тем любезен я народу,
Что чувства добрые я лирой пробуждал,
Что в мой жестокой век восславил я Свободу
И милость к падшим призывал.

Веленью божию, о муза, будь послушна,
Обиды не страшась, не требуя венца,
Хвалу и клевету приемли равнодушно,
‎И не оспоривай глупца.');

INSERT INTO works(AuthorID, TypeID, Title, TextID, CYear, GenreID) VALUES (SELECT (id) from Authors where LName = 'Пушкин', 1, 'Памятник', 1, 1836, 2);

INSERT INTO Players(Nickname,Name,Sex,Hash,Age, LastAccess, Scores, Email) VALUES ('Neo', 'Alex Arkhipov', 1,'fdfdsfdfs', 36, CURDATE(), 0, 'arkhipov@mera.ru');

INSERT INTO Stats(StatTypeID, PlayerID, AuthorID, WorkID, Played, Correct) VALUES (2, 1, 1, 1, 1, 1);
INSERT INTO Stats(StatTypeID, PlayerID, AuthorID, WorkID, Played, Correct) VALUES (2, 1, 2, 1, 2, 0);
INSERT INTO Stats(StatTypeID, PlayerID, AuthorID, WorkID, Played, Correct) VALUES (2, 1, 3, 1, 2, 2);
INSERT INTO Stats(StatTypeID, PlayerID, AuthorID, WorkID, Played, Correct) VALUES (2, 1, 1, 1, 1, 1);
DROP TABLE IF EXISTS authors;
CREATE TABLE Authors (id int primary key auto_increment, FullName varchar(255) not null, FName varchar(100) not null, MName varchar(100) not null, LName varchar(100) not null, BYear int, DYear int, Sex tinyint not null);

DROP TABLE IF EXISTS types;
CREATE TABLE Types (id int primary key, Type varchar(100) not null);

DROP TABLE IF EXISTS genres;
CREATE TABLE Genres (id int primary key, Genre varchar(100) not null);

DROP TABLE IF EXISTS texts;
CREATE TABLE Texts (id int primary key not null, Text text not null);

DROP TABLE IF EXISTS works;
CREATE TABLE Works (id int primary key auto_increment, AuthorID int not null, TextID int not null, TypeID int not null, Title varchar(255) not null, CYear int, GenreID int);
ALTER TABLE Works ADD FOREIGN KEY (AuthorID) REFERENCES Authors(id);
ALTER TABLE Works ADD FOREIGN KEY (TypeID) REFERENCES Types(id);
ALTER TABLE Works ADD FOREIGN KEY (GenreID) REFERENCES Genres(id);
ALTER TABLE Works ADD FOREIGN KEY (TextID) REFERENCES Texts(id);

DROP TABLE IF EXISTS players;
CREATE TABLE Players (id int primary key auto_increment, Nickname varchar(20) not null, Name varchar(255) not null, Sex tinyint not null, Hash varchar(255) not null, Age int, LastAccess date, Scores int, Email varchar(100) not null);

DROP TABLE IF EXISTS stattypes;
CREATE TABLE stattypes (id int primary key, StatType varchar (50) not null);

DROP TABLE IF EXISTS stats;
CREATE TABLE stats (id int primary key auto_increment, StatTypeID int not null, PlayerID int not null, AuthorId int null, WorkID int not null, Played int, Correct int); 
ALTER TABLE stats ADD FOREIGN KEY (StatTypeID) REFERENCES stattypes(id);
ALTER TABLE stats ADD FOREIGN KEY (PlayerID) REFERENCES players(id);
ALTER TABLE stats ADD FOREIGN KEY (AuthorID) REFERENCES authors(id);
ALTER TABLE stats ADD FOREIGN KEY (WorkID) REFERENCES works(id);
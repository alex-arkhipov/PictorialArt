DROP TABLE IF EXISTS authors;
CREATE TABLE Authors (
	id int primary key auto_increment,
	FullName varchar(255) not null,
	FName varchar(100) not null,
	MName varchar(100) not null,
	LName varchar(100) not null,
	BYear int,
	DYear int,
	Sex tinyint not null
);

--- Production genre
DROP TABLE IF EXISTS genres;
CREATE TABLE Genres (id int primary key not null, Genre varchar(100) not null);

--- Production description
DROP TABLE IF EXISTS Descriptions;
CREATE TABLE Descriptions (id int primary key not null, Description text not null);

DROP TABLE IF EXISTS Productions;
CREATE TABLE Productions (
	id int primary key auto_increment,
	AuthorID int,
	DescriptionID int not null,
	Title varchar(255) not null,
	CYear int,
	GenreID int,
	Filename varchar(100) not null,
	Popularity tinyint not null
);
ALTER TABLE Productions ADD FOREIGN KEY (AuthorID) REFERENCES Authors(id);
ALTER TABLE Productions ADD FOREIGN KEY (GenreID) REFERENCES Genres(id);
ALTER TABLE Productions ADD FOREIGN KEY (DescriptionID) REFERENCES Descriptions(id);

DROP TABLE IF EXISTS players;
CREATE TABLE Players (id int primary key auto_increment, Nickname varchar(20) not null, Name varchar(255) not null, Sex tinyint not null, Hash varchar(255) not null, Age int, LastAccess date, Scores int, Email varchar(100) not null);

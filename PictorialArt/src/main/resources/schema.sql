DROP TABLE IF EXISTS Production;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS Description;
DROP TABLE IF EXISTS Author;

CREATE TABLE Author (
	id int primary key auto_increment,
	FullName varchar(255) not null,
	FName varchar(100) not null,
	MName varchar(100) not null,
	LName varchar(100) not null,
	BYear int,
	DYear int,
	Sex tinyint not null
) DEFAULT CHARSET=utf8;

CREATE TABLE Genre (id int primary key not null auto_increment, Genre varchar(100) not null) DEFAULT CHARSET=utf8;

CREATE TABLE Description (id int primary key auto_increment, Description text not null) DEFAULT CHARSET=utf8;

CREATE TABLE Production (
	id int primary key auto_increment,
	AuthorID int,
	DescriptionID int not null,
	Title varchar(255) not null,
	CYear int,
	GenreID int,
	Filename varchar(100),
	Popularity tinyint
) DEFAULT CHARSET=utf8;
ALTER TABLE Production ADD FOREIGN KEY (AuthorID) REFERENCES Author(id);
ALTER TABLE Production ADD FOREIGN KEY (GenreID) REFERENCES Genre(id);
ALTER TABLE Production ADD FOREIGN KEY (DescriptionID) REFERENCES Description(id);

CREATE TABLE Player (id int primary key auto_increment, Nickname varchar(20) not null, Name varchar(255) not null, Sex tinyint not null, Hash varchar(255) not null, Age int, LastAccess date, Scores int, Email varchar(100) not null) DEFAULT CHARSET=utf8;

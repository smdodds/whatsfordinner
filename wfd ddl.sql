--CREATE USER wfd
--IDENTIFIED BY p4ssw0rd
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT connect to wfd;
--GRANT resource to wfd;
--GRANT create session to wfd;
--GRANT create table to wfd;
--GRANT create view to wfd;

--select 'drop table ' || table_name || ' cascade constraints;' from user_tables;
drop table ADMINISTRATOR cascade constraints;
drop table LOGIN cascade constraints;
drop table FRIDGE cascade constraints;
drop table INGREDIENT cascade constraints;
drop table RECIPE cascade constraints;
drop table INGREDIENTLIST cascade constraints;
drop table FRIDGE_INGREDIENTS cascade constraints;

--select 'drop sequence ' || sequence_name || ';' from user_sequences;

CREATE TABLE Login (
    Id number PRIMARY KEY,
    Username varchar2(25) UNIQUE NOT NULL,
    Password varchar2(25) NOT NULL,
    Firstname varchar2(50),
    Lastname varchar2(50),
    Email varchar2(100) UNIQUE NOT NULL
);

CREATE TABLE Administrator (
    Id number PRIMARY KEY,
	CONSTRAINT FK_Administrator_LoginId FOREIGN KEY (Id) REFERENCES Login (Id)
);

CREATE TABLE Fridge (
    Id number PRIMARY KEY,
    UserId number,
    CONSTRAINT FK_Fridge_LoginId FOREIGN KEY (UserId) REFERENCES Login (Id)
);

CREATE TABLE Ingredient (
    Id number PRIMARY KEY,
    Name varchar2(50) UNIQUE NOT NULL
);

CREATE TABLE Fridge_Ingredients (
    FridgeId number,
    IngredientId number,
    CONSTRAINT PK_FridgeIngredients PRIMARY KEY (FridgeId, IngredientId),
    CONSTRAINT FK_FridgeIngredients_FridgeId FOREIGN KEY (FridgeId) REFERENCES Fridge (Id),
    CONSTRAINT FK_FridgeIngredients_IngrdntId FOREIGN KEY (IngredientId) REFERENCES Ingredient (Id)    
);

CREATE TABLE Recipe (
    Id number PRIMARY KEY,
    Name varchar2(100) UNIQUE NOT NULL,
    Description varchar2(1000)
);

CREATE TABLE IngredientList (
    RecipeId number,
    IngredientId number,
    CONSTRAINT PK_IngredientList PRIMARY KEY (RecipeId, IngredientId),
    CONSTRAINT FK_IngredientList_RecipeId FOREIGN KEY (RecipeId) REFERENCES Recipe (Id),
    CONSTRAINT FK_IngredientList_IngredientId FOREIGN KEY (IngredientId) REFERENCES Ingredient (Id) 
);

drop sequence LOGINID_SEQ;
create sequence LOGINID_SEQ;
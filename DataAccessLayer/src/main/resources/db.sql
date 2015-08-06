CREATE DATABASE banking_system;
USE banking_system;

CREATE TABLE Clients (
  clientId INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(40) NOT NULL,
  lastName VARCHAR(100) NOT NULL,
  PRIMARY KEY (clientId));
CREATE TABLE Accounts (
  accountId INT NOT NULL AUTO_INCREMENT,
  clientId INT NOT NULL,
  accountNumber CHAR(26) NOT NULL UNIQUE,
  PRIMARY KEY (accountId),
  FOREIGN KEY (clientId) REFERENCES Clients(clientId));
CREATE TABLE Transactions(
  transactionId INT NOT NULL AUTO_INCREMENT,
  fromAccount INT NOT NULL,
  toAccount INT NOT NULL,
  date DATETIME NOT NULL,
  amount DECIMAL(16,2) NOT NULL,
  FOREIGN KEY (fromAccount) REFERENCES Accounts(accountId),
  FOREIGN KEY (toAccount) REFERENCES Accounts(accountId),
  PRIMARY KEY (transactionId));
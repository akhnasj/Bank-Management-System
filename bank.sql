CREATE DATABASE bank;
USE bank;

CREATE TABLE signup_one(
	form_no VARCHAR(30), 
    name VARCHAR(30),
    father_name VARCHAR(30),
    dob VARCHAR(20),
    gender VARCHAR(30),
    email VARCHAR(60),
    marital_status VARCHAR(20), 
    address VARCHAR(60),
    city VARCHAR(30),
    pincode VARCHAR(30),
    state VARCHAR(50)
);

CREATE TABLE signup_two(
	form_no VARCHAR(30),
    religion VARCHAR(30),
    category VARCHAR(30),
    income VARCHAR(30),
    education VARCHAR(30),
    occupation VARCHAR(60),
    pan VARCHAR(30),
    aadhar VARCHAR(30),
    senior_citizen VARCHAR(30),
    existiing_account VARCHAR(30)
);

CREATE TABLE signup_three(
	form_no VARCHAR(30),
    account_type VARCHAR(40),
    card_no VARCHAR(30),
    pin VARCHAR(30),
    service VARCHAR(200)
);

CREATE TABLE login(
	form_no VARCHAR(30),
    card_no VARCHAR(50),
    pin VARCHAR(30)
);
    
SELECT * FROM signup_one;
SELECT * FROM signup_two;
SELECT * FROM signup_three;
SELECT * FROM login;    
    
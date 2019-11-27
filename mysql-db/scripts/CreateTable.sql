CREATE TABLE route (
id BIGINT NOT NULL auto_increment,  
city VARCHAR(255) NOT NULL, 
destination_city VARCHAR(255) NOT NULL,
departure_time DATETIME NOT NULL, 
arrival_time DATETIME NOT NULL, 
primary key (id));
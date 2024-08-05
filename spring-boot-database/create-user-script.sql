DROP USER if exists 'springdb'@'localhost';

CREATE USER 'springdb'@'localhost' IDENTIFIED BY 'springdb';

GRANT ALL PRIVILEGES ON *.* TO 'springdb'@'localhost';
-- Drop user first if they exist
DROP USER if exists 'gh4abhi'@'%' ;

-- Now create user with prop privileges
CREATE USER 'gh4abhi'@'%' IDENTIFIED BY 'gh4abhi';

GRANT ALL PRIVILEGES ON * . * TO 'gh4abhi'@'%';
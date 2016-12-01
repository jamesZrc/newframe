CREATE TABLE users (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled tinyint(1) NOT NULL,
  account_non_expired tinyint(1) DEFAULT NULL,
  credentials_non_expired tinyint(1) DEFAULT NULL,
  account_non_locked tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

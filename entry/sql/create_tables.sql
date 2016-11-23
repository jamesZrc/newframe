CREATE TABLE users (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled tinyint(1) NOT NULL,
  account_non_expired tinyint(1) DEFAULT NULL,
  credentials_non_expired tinyint(1) DEFAULT NULL,
  account_non_locked tinyint(1) DEFAULT NULL,
  PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

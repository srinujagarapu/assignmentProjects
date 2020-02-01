DROP TABLE IF EXISTS StoreDetails;

CREATE TABLE StoreDetails (
  ID   INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(250),
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  address2 VARCHAR(250) ,
  city  VARCHAR(250) NOT NULL,
  state VARCHAR(3) NOT NULL,
  zip VARCHAR(10) NOT NULL,
  hours VARCHAR(500) ,
  services VARCHAR(1000)
  
  
);


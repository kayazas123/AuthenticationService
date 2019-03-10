CREATE TABLE security_role (
  id integer generated always as identity,
  description varchar(100) DEFAULT NULL,
  role_name varchar(100) DEFAULT NULL,
   PRIMARY KEY (id)
);



CREATE TABLE security_user (
  id integer generated always as identity,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  PRIMARY KEY (id)

);



CREATE TABLE user_role (
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT FK_SECURITY_USER_ID FOREIGN KEY (user_id) REFERENCES security_user (id),
  CONSTRAINT FK_SECURITY_ROLE_ID FOREIGN KEY (role_id) REFERENCES security_role (id)
);

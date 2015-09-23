CREATE TABLE user
(
  user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  username VARCHAR(400) NOT NULL,
  password VARCHAR(400) NOT NULL
);

CREATE TABLE message (
  message_id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title varchar(100) DEFAULT NULL,
  body text,
  sender_id bigint(20) DEFAULT NULL,
  creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (sender_id) REFERENCES user(user_id)
);

INSERT INTO user (username, password) VALUES ("testUser", "$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y");
INSERT INTO user (username, password) VALUES ("testAdmin", "$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y");
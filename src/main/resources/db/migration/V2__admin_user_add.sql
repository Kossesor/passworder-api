INSERT INTO passworder.users (id, active, username, email, password)
VALUES (1, true, 'admin', 'default@mail.com', '$2a$08$hmTo.mmGw8u/MrkAvg6jj.OjmlkvNNfbDtSlNj6hhXw4fBDZ2Ltt2');

INSERT INTO passworder.user_role (user_id, roles)
VALUES (1, 'USER'),
       (1, 'ADMIN');
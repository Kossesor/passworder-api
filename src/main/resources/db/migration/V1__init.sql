CREATE TABLE passwords
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    title    VARCHAR(50)           NOT NULL,
    login    VARCHAR(50)           NOT NULL,
    password VARCHAR(60)           NOT NULL,
    note     VARCHAR(204)          NULL,
    CONSTRAINT pk_passwords PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    user_id BIGINT       NOT NULL,
    roles   VARCHAR(255) NULL
);

CREATE TABLE users
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    username        VARCHAR(30)           NOT NULL,
    email           VARCHAR(50)           NOT NULL,
    password        VARCHAR(60)           NOT NULL,
    active          BIT                   NOT NULL,
    activation_code VARCHAR(255)          NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE vault
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    data BLOB                  NOT NULL,
    CONSTRAINT pk_vault PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);
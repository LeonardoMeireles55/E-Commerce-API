
CREATE TABLE forgot_password (
    fk_user INT,
    user_email VARCHAR(255) NOT NULL,
    user_password VARCHAR(255),
    expiration_time TIMESTAMP,
    FOREIGN KEY (fk_user) REFERENCES users(id)
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       first_name VARCHAR(50) NOT NULL,
                       last_name VARCHAR(50) NOT NULL,
                       date_birth DATE NOT NULL,
                       postal_code VARCHAR(255),
                       state VARCHAR(255),
                       city VARCHAR(255),
                       street VARCHAR(255),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       enabled BOOLEAN DEFAULT TRUE NOT NULL,
                       user_roles VARCHAR(25) NOT NULL
);
-- Create indexes
CREATE INDEX idx_username ON users (username);
CREATE INDEX idx_email ON users (email);
CREATE INDEX idx_enabled ON users (enabled);
CREATE INDEX idx_user_roles ON users (user_roles);

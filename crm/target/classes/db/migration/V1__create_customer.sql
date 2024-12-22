CREATE TABLE IF NOT EXISTS  customer(
    id SERIAL,
    full_name VARCHAR (255) NOT NULL,
    email VARCHAR (255) NOT NULL,
    phone VARCHAR (255),
    address VARCHAR (255),
    PRIMARY KEY (id)


);
